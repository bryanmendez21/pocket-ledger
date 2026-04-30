package com.pluralsight;

import java.io.BufferedReader;
import java.io.IOException;

import static com.pluralsight.InterfaceStyle.*;
import static com.pluralsight.InterfaceStyle.BR;
import static com.pluralsight.InterfaceStyle.H;
import static com.pluralsight.InterfaceStyle.RESET;
import static com.pluralsight.InterfaceStyle.WIDTH;

public class LedgerMenu {
    public static void ledgerMenu() {
        boolean ledgerRunning = true;
        do {
            try (BufferedReader tranFile = FileManager.getReader()) { // auto closes Reader
                System.out.println(TL + WHITE + BOLD + H.repeat(WIDTH) + TR + RESET);// Top Border
                String t = "             Ledger Menu";
                System.out.println(WALL + BRIGHT_BLUE + BOLD + t + " ".repeat(WIDTH - t.length()) + WALL);
                System.out.println(WHITE + BOLD + ML + H.repeat(WIDTH) + MR + RESET); // Divider
                String a = "A) Display All";
                System.out.println(WALL + GREEN + BOLD +  a + " ".repeat(WIDTH - a.length()) + RESET + WALL);
                String d = "D) Deposits";
                System.out.println(WALL + YELLOW + BOLD + d + " ".repeat(WIDTH - d.length()) + RESET + WALL);
                String p = "P) Payments";
                System.out.println(WALL + CYAN + BOLD + p + " ".repeat(WIDTH - p.length()) + RESET + WALL);
                String r = "R) Reports";
                System.out.println(WALL + BLUE + BOLD + r + " ".repeat(WIDTH - r.length())+ RESET + WALL);
                String h = "H) Home";
                System.out.println(WALL + RED + BOLD + h + " ".repeat(WIDTH - h.length())+ RESET + WALL);
                System.out.println(BL + WHITE + BOLD + H.repeat(WIDTH) + BR + RESET); // Bottom Border

                System.out.print(BOLD +"Choose Option Using Letters: ");
                String ledgerChoice = PocketLedger.userInput.nextLine();


                switch (ledgerChoice) {
                    case "A", "a" -> {
                        System.out.println(BRIGHT_BLUE + BOLD+"---------- ALL ----------");
                        LedgerChoice("all");
                        System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                        break;
                    }
                    case "D", "d" -> { // move a,d,p into one method and call based on whats needed
                        System.out.println(BRIGHT_BLUE + BOLD +"---------- DEPOSITS ----------");
                        LedgerChoice("deposits");
                        System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                        break;
                    }
                    case "P", "p" -> {
                        System.out.println(BRIGHT_BLUE + BOLD +"---------- PAYMENTS ----------");
                        LedgerChoice("payments");
                        System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
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

            }else if ((filter.equalsIgnoreCase( "payments")) && (t.getAmount() < 0)){
                FileManager.printRow(t);

            }
        }
    }
}
