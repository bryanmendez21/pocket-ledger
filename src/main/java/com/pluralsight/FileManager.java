package com.pluralsight;

import java.io.*;

public class FileManager {  // Handles All File Writing and Reading

    // File Reader Method
    public static BufferedReader getReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
    }

    // File Writer Method Deposits and Payments
    public static void getWriter(String filter) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv",true))) {
            // true for appending
            System.out.print("Date (YYYY-MM-DD): ");
            String date = PocketLedger.userInput.nextLine();
            System.out.print("Enter Time (HH:MM:SS): ");
            String time = PocketLedger.userInput.nextLine();
            System.out.print("Description: ");
            String description = PocketLedger.userInput.nextLine();
            System.out.print("Vendor: ");
            String vendor = PocketLedger.userInput.nextLine();
            System.out.print("Amount: ");
            double amount = PocketLedger.userInput.nextDouble();
            PocketLedger.userInput.nextLine();

            if(filter.equalsIgnoreCase("positive")) {
                bw.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
                bw.newLine();
            }else if (filter.equalsIgnoreCase("negative")){
                bw.write(date + "|" + time + "|" + description + "|" + vendor + "|" + "-" + amount);
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // print header method
    public static void printHeader(){
        System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
    }

    // print statement method
    public static void printRow(Transactions t){
        System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(), t.getTime(), t.getVendor(), t.getDescription(), t.getAmount());
    }



}

