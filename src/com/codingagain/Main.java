package com.codingagain;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte monthsInYear = 12;
        final byte percentage = 100;

        System.out.print("Principle:");
        int principle = scanner.nextInt();

        System.out.print("Annual Interest Rate:");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate/monthsInYear/percentage;

        System.out.print("Period(Years):");
        int period = scanner.nextInt();
        int totalPayments = period * 12;

        double mortgage = principle
                * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), totalPayments)))
                /((Math.pow((1 + monthlyInterestRate), totalPayments)) -1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage " + mortgageFormatted);
    }

}
