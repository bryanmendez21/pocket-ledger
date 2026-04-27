package com.pluralsight;

import java.util.Locale;
import java.util.Scanner;

public class PocketLedger {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        boolean running = true;
        String returnToMain;

        do {
            System.out.println("---------- Welcome to Pocket Ledger ----------");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println("Choose Option Using Letters: ");
            String pocketLedgerMenu = userInput.nextLine();

            switch (pocketLedgerMenu){
                case "D", "d" -> {
                    System.out.println("Deposit");
                    break;
                }
                case "P", "p" -> {
                    System.out.println("Payment");
                    break;
                }
                case "L", "l" -> {
                    System.out.println("---------- Ledger Menu ----------");
                    System.out.println("A) Display All");
                    System.out.println("D) Deposits");
                    System.out.println("P) Payments");
                    System.out.println("R) Reports");
                    System.out.println("Choose Option Using Letters: ");
                    String ledgerMenuInput = userInput.nextLine();
                    switch (ledgerMenuInput){
                        case "A","a" ->{
                            System.out.println("Display all");
                            break;
                        }
                        case "D","d" ->{
                            System.out.println("view deposits");
                            break;
                        }
                        case "P","p" ->{
                            System.out.println(" view payments");
                            break;
                        }
                        case "R","r" ->{
                            System.out.println("reports");
                            break;
                        }
                    }

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



            System.out.print("Return to main menu: (yes/no): ");
            returnToMain = userInput.nextLine();

            if (returnToMain.equalsIgnoreCase("no")) {
                running = false;
            }
        } while (running);
            userInput.close();
            System.out.println("Good Bye!");

    }
}
