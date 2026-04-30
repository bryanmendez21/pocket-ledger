package com.pluralsight;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ReportMenu {

    // Menu Method Report
    public static void reportMenu() {
        boolean reportRunning = true;

        do {
            System.out.println("---------- Report Menu ----------");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");
            System.out.print("Choose Option Using Letters: ");
            int reportChoice = PocketLedger.userInput.nextInt();
            PocketLedger.userInput.nextLine();

            switch (reportChoice) {
                case 1 -> {
                    System.out.println("---- view current month ----");
                    reportSearchOptions(reportChoice, "");
                    break;
                }
                case 2 -> {
                    System.out.println("---- view previous month ----");
                    reportSearchOptions(reportChoice, "");
                    break;
                }
                case 3 -> {
                    System.out.println("---- View Current Year ----");
                    reportSearchOptions(reportChoice, "");
                    break;
                }
                case 4 -> {
                    System.out.println("---- View Previous Year ----");
                    reportSearchOptions(reportChoice, "");
                    break;
                }
                case 5 -> {
                    System.out.print(" Search By Vendor Name: ");
                    String vendorName = PocketLedger.userInput.nextLine();

                    System.out.println("---- View By Vendor ----");
                    reportSearchOptions(reportChoice, vendorName);
                }
                case 6 -> {
                    boolean customRunning = true;
                    do {
                        System.out.println("---- Custom Search ----");
                        System.out.println("S) Filter by Start/End date");
                        System.out.println("A) Filter by Amount");
                        System.out.println("D) Filter by Description");
                        System.out.println("X) Exit Custom Search");

                        System.out.println("Search using: ");
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
                System.out.println("Enter Start and End date: ");
                String startEndDate = PocketLedger.userInput.nextLine();
               break;
            }
            case "A" -> {
                System.out.println("Enter Amount: ");
                double amountSearch = PocketLedger.userInput.nextDouble();
                PocketLedger.userInput.nextLine();
                break;
            }
            case "D" -> {
                System.out.println("Enter Description or KeyWords: ");
                PocketLedger.userInput.nextLine();

                break;
            }
            default -> System.out.println("Invalid Input");
        }
    }

    // Custom Search Key word
}

