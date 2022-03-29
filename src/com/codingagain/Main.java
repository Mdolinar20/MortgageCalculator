package com.codingagain;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte monthsInYear = 12;
        final byte percentage = 100;


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

        float monthlyInterestRate = annualInterestRate/monthsInYear/percentage;

        int period;
        do {
            System.out.print("Period(Years):");
            period = scanner.nextInt();
        } while (period <= 0 || period >= 30);
        int totalPayments = period * 12;

        double mortgage = principle
                * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), totalPayments)))
                /((Math.pow((1 + monthlyInterestRate), totalPayments)) -1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage " + mortgageFormatted);
    }

}
