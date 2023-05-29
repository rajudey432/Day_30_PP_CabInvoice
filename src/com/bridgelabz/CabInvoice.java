package com.bridgelabz;


public class CabInvoice {
    public static void main(String[] args) {
        double distance = 15.5; // Distance in kilometers
        double time = 30.0; // Time in minutes

        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(distance, time);

        System.out.println("Total fare: Rs. " + fare);
    }
}

