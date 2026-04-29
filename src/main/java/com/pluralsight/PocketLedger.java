package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PocketLedger {
    static  Scanner userInput = new Scanner(System.in); // shared across entire class
    public static void main(String[] args) {

        boolean running = true;

        do {
            System.out.println("---------- Welcome to Pocket Ledger ----------");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose Option Using Letters: ");
            String homeChoice = userInput.nextLine().trim().toUpperCase(); //.lowercase

            switch (homeChoice){
                case "D" -> {
                    System.out.println("Deposit info");
                    FileManager.getWriter("positive");
                    break;
                }
                case "P" -> {
                    System.out.println("Payment info");
                    FileManager.getWriter("negative");
                    break;
                }
                case "L" -> {
                    LedgerMenu.ledgerMenu();
                    break;
                }
                case "X" -> running = false;

                default -> {
                    System.out.println("Invalid Input");
                    break;
                }
            }

        } while (running);
            userInput.close();
            System.out.println("Good Bye!");

    }
}
