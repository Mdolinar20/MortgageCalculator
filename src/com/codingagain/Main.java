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
        } while (period <= 0 || period >= 30);

        double mortgage = calculateMortgage(principle, annualInterestRate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage " + mortgageFormatted);

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

}
