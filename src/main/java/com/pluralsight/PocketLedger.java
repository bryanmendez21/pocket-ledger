package com.pluralsight;

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
                    System.out.println("Deposit");
                    break;
                }
                case "P", "p" -> {
                    System.out.println("Payment");
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

    // Menu Methods
    public static void ledgerMenu(){
        System.out.println("---------- Ledger Menu ----------");
        System.out.println("A) Display All");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.println("H) Home");
        System.out.print("Choose Option Using Letters: ");
        String ledgerChoice = userInput.nextLine();
        switch (ledgerChoice){
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
            case "H","h" ->{
                return; // exits method and returns main menu

            }
            default -> {
                System.out.println("Invalid Input");
                break;
            }
        }
    }

}
