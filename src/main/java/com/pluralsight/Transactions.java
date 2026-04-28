package com.pluralsight;

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


}
