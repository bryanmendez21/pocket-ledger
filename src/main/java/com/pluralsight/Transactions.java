package com.pluralsight;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Transactions {

    // Attributes
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    //Constructor
    public Transactions(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Date Setter and Getter
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Time Setter and Getter
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // Description Setter and Getter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // Vendor Setter and Getter
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    // Amount Setter and Getter
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }




    // All Transaction Method
    public static ArrayList<Transactions> loadTransaction() {
        ArrayList<Transactions> transaction = new ArrayList<>();

            try (BufferedReader tranFile = FileManager.getReader()){

                String fileData;
                tranFile.readLine(); // Skip Header
                while ((fileData = tranFile.readLine()) != null) {
                    if (fileData.trim().isEmpty())continue;
                    String[] splitData = fileData.split(Pattern.quote("|"));
                    //split
                    String date = splitData[0];
                    String time = splitData[1];
                    String description = splitData[2];
                    String vendor = splitData[3];
                    double amount = Double.parseDouble(splitData[4]);

                    transaction.add(new Transactions(date, time, description, vendor, amount));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            transaction.sort(Comparator.comparing(Transactions::getDate).thenComparing(Transactions::getTime).reversed());

            return transaction;
    }

}
