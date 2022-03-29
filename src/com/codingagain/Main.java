package com.codingagain;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int principle;
        do {
            System.out.print("Principle  ($1k - $1M):");
            principle = scanner.nextInt();
        } while (principle <= 1_000 || principle >= 1_000_000);

        float annualInterestRate;
        do {
            System.out.print("Annual Interest Rate:");
            annualInterestRate = scanner.nextFloat();
        } while (!(annualInterestRate > 1) || !(annualInterestRate < 30));


        byte period;
        do {
            System.out.print("Period(Years):");
            period = scanner.nextByte();
        } while (period <= 0 || period > 30);

        double mortgage = calculateMortgage(principle, annualInterestRate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("===========");
        System.out.print("Mortgage " + mortgageFormatted);
        System.out.println();
        System.out.println("===========");

        balanceRemaining(principle, annualInterestRate, period);

    }

    public static double calculateMortgage(int principle,
                                           float annualInterestRate,
                                           byte period){
        final byte monthsInYear = 12;
        final byte percentage = 100;


        int totalPayments = period * monthsInYear;
        float monthlyInterestRate = annualInterestRate/monthsInYear/percentage;

        return
                (principle
                * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), totalPayments)))
                /((Math.pow((1 + monthlyInterestRate), totalPayments)) -1)));

    }



    public static void balanceRemaining(int principle, float annualInterest, byte period){
        double remaning = principle;
        byte paymentsMade = 0;
        final byte monthsInYear = 12;
        final byte percentage = 10;
        int totalPayments = period * monthsInYear;
        float monthlyInterest = annualInterest/monthsInYear/percentage;

        while(remaning > 0){
            System.out.println(remaning);
            double balance = principle *
                    ((Math.pow((1 + monthlyInterest), totalPayments) - (Math.pow((1 + monthlyInterest), paymentsMade)))
                    / (Math.pow((1 + monthlyInterest), totalPayments) - 1));
            remaning = balance;
            paymentsMade ++;
        }
    }

}
