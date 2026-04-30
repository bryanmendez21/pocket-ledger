package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.pluralsight.InterfaceStyle.*;
public class FileManager {  // Handles All File Writing and Reading

    // File Reader Method
    public static BufferedReader getReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
    }

    // File Writer Method Deposits and Payments
    public static void getWriter(String filter) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv",true))) {
            // true for appending
            System.out.print("Date (YYYY-MM-DD) or press Enter for today: ");
            String date = PocketLedger.userInput.nextLine();
            if (date.trim().isEmpty()){
                date = LocalDate.now().toString(); //gives today time
            }
            System.out.print("Enter Time (HH:MM:SS) or press Enter for: ");
            String time = PocketLedger.userInput.nextLine();
            if (time.trim().isEmpty()){
                time = LocalTime.now().withNano(0).toString(); // gives time enter is pressed without nanoseconds
            }
            System.out.print("Description: ");
            String description = PocketLedger.userInput.nextLine();
            System.out.print("Vendor: ");
            String vendor = PocketLedger.userInput.nextLine();
            System.out.print("Amount: ");
            double amount = PocketLedger.userInput.nextDouble();
            PocketLedger.userInput.nextLine();

            if(filter.equalsIgnoreCase("positive")) {
                bw.newLine();
                bw.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);

            }else if (filter.equalsIgnoreCase("negative")){
                bw.newLine();
                bw.write(date + "|" + time + "|" + description + "|" + vendor + "|" + "-" + amount);

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // print header method
    public static void printHeader(){
        System.out.println(TL + WHITE + BOLD + H.repeat(OUTPUTWIDTH) + TR + RESET);// Top Border
        String h ="    DATE   |   TIME   |  VENDOR  |   DESCRIPTION  |  AMOUNT";
        System.out.println(WALL + BRIGHT_BLUE + h + " ".repeat(OUTPUTWIDTH - h.length()) + RESET + WALL);
        System.out.println(BL +WHITE + BOLD + H.repeat(OUTPUTWIDTH) + BR + RESET); // Divider
    }

    // print statement method
    public static void printRow(Transactions t){
        String color = t.getAmount() > 0 ? BRIGHT_GREEN : BRIGHT_RED; // ? ternary operator one line if/else
        System.out.printf("%s | %s | %s | %s |"+ color +"%.2f\n" + RESET, t.getDate(), t.getTime(), t.getVendor(), t.getDescription(), t.getAmount());

    }

}

