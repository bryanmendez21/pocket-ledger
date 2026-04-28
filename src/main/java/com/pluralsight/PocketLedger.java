package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PocketLedger {
    static  Scanner userInput = new Scanner(System.in); // shared across entire class
    public static void main(String[] args) {

        boolean running = true;

        do {
            System.out.println("---------- Welcome to Pocket Ledger ----------");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose Option Using Letters: ");
            String homeChoice = userInput.nextLine(); //.lowercase

            switch (homeChoice){
                case "D", "d" -> {
                    getWriter();
                    break;
                }
                case "P", "p" -> {
                    System.out.println("Payment info");
                    getWriter();
                    break;
                }
                case "L", "l" -> {
                   ledgerMenu();
                   break;
                }
                case "X", "x" ->{
                    running = false;
                    continue;
                }
                default -> {
                    System.out.println("Invalid Input");
                    break;
                }
            }


        } while (running);
            userInput.close();
            System.out.println("Good Bye!");

    }

    // Menu Method Ledger
    public static void ledgerMenu(){
        try(BufferedReader tranFile = getReader()) { // auto closes Reader
            System.out.println("---------- Ledger Menu ----------");
            System.out.println("A) Display All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose Option Using Letters: ");
            String ledgerChoice = userInput.nextLine();

            ArrayList<Transactions> transactions = loadTransaction(); // get whole list
            switch (ledgerChoice) {
                case "A", "a" -> {
                    System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
                    for (Transactions t : transactions) { // iterate through list
                        System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());
                    }
                    break;
                }
                case "D", "d" -> {
                    System.out.println("---------- DEPOSITS ----------");
                    System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
                    for (Transactions t : transactions) { // iterate through list
                        if(t.getAmount() > 0){
                            System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());
                        }
                    }
                    break;
                }
                case "P", "p" -> {
                    System.out.println("---------- PAYMENTS ----------");
                    System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
                    for (Transactions t : transactions) { // iterate through list
                        if(t.getAmount() < 0){
                            System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());
                        }
                    }
                    break;
                }
                case "R", "r" -> {
                    reportMenu();
                    break;
                }
                case "H", "h" -> {
                    return; // exits method and returns main menu

                }
                default -> {
                    System.out.println("Invalid Input");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Menu Method Report
    public static void reportMenu() {
        System.out.println("---------- Report Menu ----------");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back");
        System.out.print("Choose Option Using Letters: ");
        int reportChoice = userInput.nextInt();
        userInput.nextLine();
        switch (reportChoice) {
            case 1 -> {

                break;
            }
            case 2 -> {
                System.out.println("view deposits");
                break;
            }
            case 3 -> {
                System.out.println(" view payments");
                break;
            }
            case 4 -> {
                System.out.println("reports");
                break;
            }
            case 5 -> {
                System.out.println("Vendor Name:");
                String vendorName = userInput.nextLine();

            }
            case 0 -> {
                 // Needs updating to return to ledger menu

            }
            default -> {
                System.out.println("Invalid Input");
                break;
            }
        }
    }
    // File Reader Method
   public static BufferedReader getReader() throws FileNotFoundException {
       return new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
   }

    // File Writer Method Deposits and Payments
    public static void getWriter() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv",true))) {
            // true for appending
            System.out.print("Date (YYYY-MM-DD): ");
            String date = userInput.nextLine();
            System.out.print("Enter Time (HH:MM:SS): ");
            String time = userInput.nextLine();
            System.out.print("Description: ");
            String description = userInput.nextLine();
            System.out.print("Vendor: ");
            String vendor = userInput.nextLine();
            System.out.print("Amount: ");
            double amount = userInput.nextDouble();
            userInput.nextLine();

            bw.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
            bw.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // All Transaction Method
    public static ArrayList<Transactions> loadTransaction() {
        ArrayList<Transactions> transaction = new ArrayList<>();

        try (BufferedReader tranFile = getReader()) {

            String fileData;
            tranFile.readLine(); // Skip Header
            while ((fileData = tranFile.readLine()) != null) {
                String[] splitData = fileData.split(Pattern.quote("|"));
                //split
                String date = splitData[0];
                String time = splitData[1];
                String description = splitData[2];
                String vendor = splitData[3];
                double amount = Double.parseDouble(splitData[4]);

                //System.out.printf("%s | %s | %s | %s | %.2f\n", date, time, vendor, description, amount);
                transaction.add(new Transactions(date,time,description,vendor,amount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transaction;
    }

    // Deposit and Payment method




}
