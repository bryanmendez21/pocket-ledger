package com.pluralsight;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class LedgerMenu {
    public static void ledgerMenu() {
        boolean ledgerRunning = true;
        do {
            try (BufferedReader tranFile = FileManager.getReader()) { // auto closes Reader
                System.out.println("---------- Ledger Menu ----------");
                System.out.println("A) Display All");
                System.out.println("D) Deposits");
                System.out.println("P) Payments");
                System.out.println("R) Reports");
                System.out.println("H) Home");
                System.out.print("Choose Option Using Letters: ");
                String ledgerChoice = PocketLedger.userInput.nextLine();


                switch (ledgerChoice) {
                    case "A", "a" -> {
                        LedgerChoice("all");
                        break;
                    }
                    case "D", "d" -> { // move a,d,p into one method and call based on whats needed
                        System.out.println("---------- DEPOSITS ----------");
                        LedgerChoice("deposits");
                        break;
                    }
                    case "P", "p" -> {
                        System.out.println("---------- PAYMENTS ----------");
                        LedgerChoice("payments");
                        break;
                    }
                    case "R", "r" -> {
                        ReportMenu.reportMenu();
                        break;
                    }
                    case "H", "h" -> ledgerRunning = false;

                    default -> {
                        System.out.println("Invalid Input");
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(ledgerRunning);
    }
    public static void LedgerChoice(String filter){ //filter by string
        FileManager.printHeader();

        for (Transactions t : Transactions.loadTransaction()) { // iterate through list

            if (filter.equalsIgnoreCase("all")){
                FileManager.printRow(t);

            }else if ((filter.equalsIgnoreCase("deposits")) && (t.getAmount() > 0)){
                FileManager.printRow(t);

            }else if ((filter.equalsIgnoreCase("payments")) && (t.getAmount() < 0)){
                FileManager.printRow(t);

            }
        }
    }
}
