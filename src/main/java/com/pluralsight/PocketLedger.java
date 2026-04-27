package com.pluralsight;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

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
            String homeChoice = userInput.nextLine();

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
        try(BufferedReader tranFile = getReader()) { // auto closes
            System.out.println("---------- Ledger Menu ----------");
            System.out.println("A) Display All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose Option Using Letters: ");
            String ledgerChoice = userInput.nextLine();
            switch (ledgerChoice) {
                case "A", "a" -> {
                    System.out.println("Display all");
                    break;
                }
                case "D", "d" -> {
                    System.out.println("view deposits");
                    break;
                }
                case "P", "p" -> {
                    System.out.println(" view payments");
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
                System.out.println("Display all");
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
        return new BufferedReader (new FileReader("src/main/resources/transactions.csv"));
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


}
