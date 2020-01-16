package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

public class MortgageInstallmentCalculator {
	
    public static double calculateMonthlyPayment(
            int principal_amount, int termInYears, double rateofInterest) {

        if (principal_amount < 0 || termInYears <= 0 || rateofInterest < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }

        rateofInterest /= 100.0;

        double termInMonths = termInYears * 12;

        if(rateofInterest==0)
            return  principal_amount/termInMonths;

        double monthlyRate = rateofInterest / 12.0;

        double monthlyPayment = (principal_amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));

        return monthlyPayment;
    }
}
