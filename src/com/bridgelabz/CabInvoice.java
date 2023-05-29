package com.bridgelabz;


import java.util.ArrayList;
import java.util.List;

class CabInvoiceGenerator2 {
    private static final double COST_PER_KILOMETER = 10.0;
    private static final double COST_PER_MINUTE = 1.0;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, double time) {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateAggregateFare(List<Ride> rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }
}

public class CabInvoice {
    public static void main(String[] args) {
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(15.5, 30.0));  // Ride 1
        rides.add(new Ride(10.2, 20.0));  // Ride 2
        rides.add(new Ride(5.0, 15.0));   // Ride 3

        CabInvoiceGenerator2 invoiceGenerator = new CabInvoiceGenerator2();
        double aggregateFare = invoiceGenerator.calculateAggregateFare(rides);

        System.out.println("Aggregate total fare for all rides: Rs. " + aggregateFare);
    }
}
