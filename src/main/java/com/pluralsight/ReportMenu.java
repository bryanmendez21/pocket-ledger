package com.pluralsight;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ReportMenu {

    // Menu Method Report
    public static void reportMenu() {
        System.out.println("---------- Report Menu ----------");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back");
        System.out.print("Choose Option Using Letters: ");
        int reportChoice = PocketLedger.userInput.nextInt();
        PocketLedger.userInput.nextLine();

        switch (reportChoice) {
            case 1 -> {
                System.out.println("---- view current month ----");
                reportSearchOptions( reportChoice,"" );
               // int currentYear = LocalDate.now().getYear();
               // int currentMonth = LocalDate.now().getMonthValue();
               // int currentDay = LocalDate.now().getDayOfMonth();

               // System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
                //for (Transactions t : transactions) { // iterate through list

                   // String[] dateSplit = t.getDate().split(Pattern.quote("-"));

                   // int year = Integer.parseInt(dateSplit[0]);
                    //int month = Integer.parseInt(dateSplit[1]);
                    //int day = Integer.parseInt(dateSplit[2]);

                   // if (month == currentMonth) {
                  //      System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(), t.getTime(), t.getVendor(), t.getDescription(), t.getAmount());
                  //  }
                //}
                break;
            }
            case 2 -> {
                System.out.println("---- view previous month ----");
                reportSearchOptions( reportChoice,"" );
              //  int currentYear = LocalDate.now().getYear();
               // int currentMonth = LocalDate.now().getMonthValue();
              //  int currentDay = LocalDate.now().getDayOfMonth();

              //  System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
               // for (Transactions t : transactions) { // iterate through list

                   // String[] dateSplit = t.getDate().split(Pattern.quote("-"));

                   // int year = Integer.parseInt(dateSplit[0]);
                   // int month = Integer.parseInt(dateSplit[1]);
                   // int day = Integer.parseInt(dateSplit[2]);

                   // if (month == currentMonth -1 && year == currentYear) {
                     //   System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(), t.getTime(), t.getVendor(), t.getDescription(), t.getAmount());
                  //  }
              //  }
                break;
            }
            case 3 -> {
                System.out.println("---- View Current Year ----");
                reportSearchOptions( reportChoice,"" );
               // int currentYear = LocalDate.now().getYear();
               // int currentMonth = LocalDate.now().getMonthValue();
                //int currentDay = LocalDate.now().getDayOfMonth();

              //  System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
               // for (Transactions t : transactions) { // iterate through list

                  //  String [] dateSplit = t.getDate().split(Pattern.quote("-"));

                  //  int year = Integer.parseInt(dateSplit[0]);
                  //  int month = Integer.parseInt(dateSplit[1]);
                  //  int day = Integer.parseInt(dateSplit[2]);

                   // if (year == currentYear) {
                   //     System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());
                  //  }
               // }
                break;
            }
            case 4 -> {
                System.out.println("---- View Previous Year ----");
                reportSearchOptions( reportChoice,"" );
               // int currentYear = LocalDate.now().getYear();
               // int currentMonth = LocalDate.now().getMonthValue();
                //int currentDay = LocalDate.now().getDayOfMonth();

               // System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
               // for (Transactions t : transactions) { // iterate through list

                   // String [] dateSplit = t.getDate().split(Pattern.quote("-"));

                   // int year = Integer.parseInt(dateSplit[0]);
                   // int month = Integer.parseInt(dateSplit[1]);
                   // int day = Integer.parseInt(dateSplit[2]);

                   // if (year == currentYear -1) {
                      //  System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());
                   // }
               // }
                break;
            }
            case 5 -> {
                System.out.print("Vendor Name: ");
                String vendorName = PocketLedger.userInput.nextLine();

                System.out.println("---- View By Vendor ----");
                reportSearchOptions(reportChoice,vendorName);
                //System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
                //for (Transactions t : transactions) { // iterate through list
                 //   if(t.getVendor().equalsIgnoreCase(vendorName)){
                  //      System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());
                  //  }
               // }

            }
            case 0 -> {
                // put switch case in loop to continue going until 0 is pressed
                break;

            }
            default -> {
                System.out.println("Invalid Input");
                break;
            }
        }
    }

    // Method for all search options
    public static void reportSearchOptions(int reportChoice, String vendorName) {

        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        int currentDay = LocalDate.now().getDayOfMonth();

        System.out.println("    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT");
        for (Transactions t : Transactions.loadTransaction()) { // iterate through list

            String [] dateSplit = t.getDate().split(Pattern.quote("-"));

            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[2]);

            if (reportChoice == 1 && month == currentMonth && year == currentYear) { // case 1
                System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(), t.getTime(), t.getVendor(), t.getDescription(), t.getAmount());

            } else if (reportChoice == 2 && month == currentMonth -1 && year == currentYear) { // case 2
                System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(), t.getTime(), t.getVendor(), t.getDescription(), t.getAmount());

            } else if (reportChoice == 3 && year == currentYear) { //case 3
                System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());

            } else if (reportChoice == 4 && year == currentYear -1) { // case 4
                System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());

            } else if (reportChoice == 5 && t.getVendor().equalsIgnoreCase(vendorName)){ // case 5
                System.out.printf("%s | %s | %s | %s | %.2f\n", t.getDate(),t.getTime(),t.getVendor(),t.getDescription(),t.getAmount());

            }
        }

    }
}

