package com.pluralsight;

import java.time.LocalDate;
import java.util.regex.Pattern;

import static com.pluralsight.InterfaceStyle.*;
import static com.pluralsight.InterfaceStyle.BR;
import static com.pluralsight.InterfaceStyle.H;
import static com.pluralsight.InterfaceStyle.RESET;
import static com.pluralsight.InterfaceStyle.WIDTH;

public class ReportMenu {

    // Menu Method Report
    public static void reportMenu() {
        boolean reportRunning = true;

        do {
            System.out.println(TL + WHITE + BOLD + H.repeat(WIDTH) + TR + RESET);// Top Border
            String t = "             Report Menu ";
            System.out.println(WALL + BRIGHT_BLUE + BOLD + t + " ".repeat(WIDTH - t.length()) + WALL);
            System.out.println(WHITE + BOLD + ML + H.repeat(WIDTH) + MR + RESET); // Divider
            String a = "1) Month To Date";
            System.out.println(WALL + GREEN + BOLD +  a + " ".repeat(WIDTH - a.length()) + RESET + WALL);
            String b = "2) Previous Month";
            System.out.println(WALL + YELLOW + BOLD + b + " ".repeat(WIDTH - b.length()) + RESET + WALL);
            String c = "3) Year To Date";
            System.out.println(WALL + CYAN + BOLD + c + " ".repeat(WIDTH - c.length()) + RESET + WALL);
            String d = "4) Previous Year";
            System.out.println(WALL + BLUE + BOLD + d + " ".repeat(WIDTH - d.length())+ RESET + WALL);
            String e = "5) Search by Vendor";
            System.out.println(WALL + MAGENTA + BOLD + e + " ".repeat(WIDTH - e.length())+ RESET + WALL);
            String f = "6) Custom Search";
            System.out.println(WALL + BRIGHT_GREEN + BOLD + f + " ".repeat(WIDTH - f.length())+ RESET + WALL);
            String g = "0) Back";
            System.out.println(WALL + RED + BOLD + g + " ".repeat(WIDTH - g.length())+ RESET + WALL);
            System.out.println(BL + WHITE + BOLD + H.repeat(WIDTH) + BR + RESET); // Bottom Border


            System.out.print(BOLD +"Choose Option Using Letters: ");
            int reportChoice = PocketLedger.userInput.nextInt();
            PocketLedger.userInput.nextLine();

            switch (reportChoice) {
                case 1 -> {
                    System.out.println(BRIGHT_BLUE + BOLD + "---- view current month ----");
                    reportSearchOptions(reportChoice, "");
                    System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                    break;
                }
                case 2 -> {
                    System.out.println(BRIGHT_BLUE + BOLD +"---- view previous month ----");
                    reportSearchOptions(reportChoice, "");
                    System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                    break;
                }
                case 3 -> {
                    System.out.println(BRIGHT_BLUE + BOLD +"---- View Current Year ----");
                    reportSearchOptions(reportChoice, "");
                    System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                    break;
                }
                case 4 -> {
                    System.out.println(BRIGHT_BLUE + BOLD +"---- View Previous Year ----");
                    reportSearchOptions(reportChoice, "");
                    System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                    break;
                }
                case 5 -> {
                    System.out.print(BOLD +" Search By Vendor Name: ");
                    String vendorName = PocketLedger.userInput.nextLine();

                    System.out.println(BRIGHT_BLUE + BOLD +"---- View By Vendor ----");
                    reportSearchOptions(reportChoice, vendorName);
                    System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                }
                case 6 -> {
                    boolean customRunning = true;
                    do {
                        System.out.println(TL + WHITE + BOLD + H.repeat(WIDTH) + TR + RESET);// Top Border
                        String ot = "      Custom Search ";
                        System.out.println(WALL + BRIGHT_BLUE + BOLD + ot + " ".repeat(WIDTH - ot.length()) + WALL);
                        System.out.println(WHITE + BOLD + ML + H.repeat(WIDTH) + MR + RESET); // Divider
                        String S = "S) Filter by Start/End date";
                        System.out.println(WALL + GREEN + BOLD +  S + " ".repeat(WIDTH - S.length()) + RESET + WALL);
                        String A = "A) Filter by Amount";
                        System.out.println(WALL + YELLOW + BOLD + A + " ".repeat(WIDTH - A.length()) + RESET + WALL);
                        String D = "D) Filter by Description";
                        System.out.println(WALL + CYAN + BOLD + D + " ".repeat(WIDTH - D.length()) + RESET + WALL);
                        String x = "X) Exit Custom Search";
                        System.out.println(WALL + RED + BOLD + x + " ".repeat(WIDTH - x.length())+ RESET + WALL);
                        System.out.println(BL + WHITE + BOLD + H.repeat(WIDTH) + BR + RESET); // Bottom Border

                        System.out.print(BOLD +"Search using: ");
                        String customChoice = PocketLedger.userInput.nextLine().toUpperCase();

                        if(customChoice.equalsIgnoreCase("X")){
                            customRunning = false;
                        }else {
                            customSearch(customChoice);
                        }

                    }while(customRunning);
                    break;
                }
                case 0 -> reportRunning = false;

                default -> { //add if statement in case user inputs char or string
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }while(reportRunning);
    }

    // Method for all search options
    public static void reportSearchOptions(int reportChoice, String vendorName) {

        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        int currentDay = LocalDate.now().getDayOfMonth();

        FileManager.printHeader();

        for (Transactions t : Transactions.loadTransaction()) { // iterate through list

            String [] dateSplit = t.getDate().split(Pattern.quote("-"));

            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[2]);

            if (reportChoice == 1 && month == currentMonth && year == currentYear) { // case 1
                FileManager.printRow(t);

            } else if (reportChoice == 2 && month == currentMonth -1 && year == currentYear) { // case 2
                FileManager.printRow(t);

            } else if (reportChoice == 3 && year == currentYear) { //case 3
                FileManager.printRow(t);

            } else if (reportChoice == 4 && year == currentYear -1) { // case 4
                FileManager.printRow(t);

            } else if (reportChoice == 5 && t.getVendor().equalsIgnoreCase(vendorName)){ // case 5
                FileManager.printRow(t);

            }

        }
    }

    // Custom Search Method
    public static void customSearch(String customChoice){
        switch(customChoice) {
            case "S" ->{
                System.out.print(BOLD + "Enter Start date: ");
                String startDate = PocketLedger.userInput.nextLine();
                System.out.print(BOLD + "Enter End date: ");
                String endDate = PocketLedger.userInput.nextLine();

                customSearchStartEnd(startDate,endDate);
                System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
               break;
            }
            case "A" -> {
                System.out.print(BOLD + "Enter Amount: ");
                double amountSearch = PocketLedger.userInput.nextDouble();
                PocketLedger.userInput.nextLine();

                customSearchAmount(amountSearch);
                System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                break;
            }
            case "D" -> {
                System.out.print(BOLD + "Enter Description or KeyWords: ");
                String descriptionSearch = PocketLedger.userInput.nextLine().toUpperCase();

                customSearchDescription(descriptionSearch);
                System.out.println(WHITE + BOLD + H.repeat(OUTPUTWIDTH) + RESET); // Bottom Border
                break;
            }
            default -> System.out.println("Invalid Input");
        }
    }

    // Custom Search date
    public static void customSearchStartEnd(String startDate,String endDate){
        boolean found = false;
        for (Transactions t : Transactions.loadTransaction()){
            String date = t.getDate();

            boolean afterStart = startDate.isEmpty() || date.compareTo(startDate) >= 0;
            boolean beforeEnd = endDate.isEmpty() || date.compareTo(endDate) <= 0;

            if(afterStart && beforeEnd){
                FileManager.printRow(t);
                found = true;
            }
        }
        if (!found){
            System.out.println("Dates not found");

        }

    }

    // Custom Search Amount
    public static void customSearchAmount(double amountSearch){
        boolean found = false;
        for (Transactions t : Transactions.loadTransaction()){
            if (t.getAmount() == amountSearch){
                FileManager.printRow(t);
                found = true;
            }
        }
        if (!found){
            System.out.println("Amount not found");
        }

    }

    // Custom Search Key word
    public static void customSearchDescription(String descriptionSearch){
        boolean found = false;
        for (Transactions t : Transactions.loadTransaction()){
            if (t.getDescription().toUpperCase().contains(descriptionSearch)){
                FileManager.printRow(t);
                found = true;
            }
        }
        if (!found){
            System.out.println("Description not found");
        }

    }

}

