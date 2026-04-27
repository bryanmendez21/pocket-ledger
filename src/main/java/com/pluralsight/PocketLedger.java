package com.pluralsight;

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

            System.out.print("Would you want to go back (yes/no): ");
            returnToMain = userInput.nextLine();

            if (returnToMain.equalsIgnoreCase("no")) {
                running = false;
            }
        } while (running);
            userInput.close();
            System.out.println("Good Bye!");

    }
}
