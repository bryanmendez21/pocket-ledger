package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LedgerMenu {
    public static void ledgerMenu() {
        try(BufferedReader tranFile = FileManager.getReader()) { // auto closes Reader
            System.out.println("---------- Ledger Menu ----------");
            System.out.println("A) Display All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose Option Using Letters: ");
            String ledgerChoice = PocketLedger.userInput.nextLine();

            ArrayList<Transactions> transactions = Transactions.loadTransaction(); // get whole list
            switch (ledgerChoice) {
                case "A", "a" -> {
                    System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
                    for (Transactions t : transactions) { // iterate through list
                        System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());
                    }
                    break;
                }
                case "D", "d" -> { // move a,d,p into one method and call based on whats needed
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
                    ReportMenu.reportMenu();
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
}
