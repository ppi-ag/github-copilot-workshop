package de.ppi.tasks.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanCalculator {

    /**
     * Calculates the monthly payment for a loan based on the formula:
     * M = P * r * (1 + r)^n / ((1 + r)^n - 1)
     *
     * @param principal          The total amount of the loan (P)
     * @param annualInterestRate The annual interest rate as a percentage (e.g., 5
     *                           for 5%)
     * @param years              The term of the loan in years (n)
     * @return The monthly payment (M)
     */
    public double calculateMonthlyPayment(double principal, double annualInterestRate, int years) {
        if (principal <= 0 || annualInterestRate <= 0 || years <= 0) {
            throw new IllegalArgumentException("Inputs must be greater than 0.");
        }

        BigDecimal monthlyInterestRate = BigDecimal.valueOf(annualInterestRate / 100 / 12);
        int totalPayments = years * 12;

        BigDecimal onePlusRateToPower = monthlyInterestRate.add(BigDecimal.ONE).pow(totalPayments);
        BigDecimal numerator = BigDecimal.valueOf(principal).multiply(monthlyInterestRate).multiply(onePlusRateToPower);
        BigDecimal denominator = onePlusRateToPower.subtract(BigDecimal.ONE);

        return numerator.divide(denominator, 2, RoundingMode.HALF_UP).doubleValue();
    }

}
