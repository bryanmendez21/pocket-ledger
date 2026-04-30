package com.pluralsight;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import static com.pluralsight.InterfaceStyle.*;

public class PocketLedger {
    static  Scanner userInput = new Scanner(System.in); // shared across entire class
    public static void main(String[] args) {

        boolean running = true;

        do {
            System.out.println(TL + WHITE + BOLD + H.repeat(WIDTH) + TR + RESET);// Top Border
            String t = "       Welcome to Pocket Ledger ";
            System.out.println(WALL + BRIGHT_BLUE + BOLD + t + " ".repeat(WIDTH - t.length()) + WALL);
            System.out.println(WHITE + BOLD + ML + H.repeat(WIDTH) + MR + RESET); // Divider
            String d = "D) Add Deposit";
            System.out.println(WALL + GREEN + BOLD +  d + " ".repeat(WIDTH - d.length()) + RESET + WALL);
            String p = "P) Make Payment";
            System.out.println(WALL + YELLOW + BOLD + p + " ".repeat(WIDTH - p.length()) + RESET + WALL);
            String l = "L) Ledger";
            System.out.println(WALL + CYAN + BOLD + l + " ".repeat(WIDTH - l.length()) + RESET + WALL);
            String x = "X) Exit";
            System.out.println(WALL + RED + BOLD + x + " ".repeat(WIDTH - x.length())+ RESET + WALL);
            System.out.println(BL + WHITE + BOLD + H.repeat(WIDTH) + BR + RESET); // Bottom Border

            System.out.print(BOLD + "Choose Option Using Letters: ");
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
