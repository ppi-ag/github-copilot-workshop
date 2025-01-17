package de.ppi.tasks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LoanCalculatorTest {

    @Test
    public void testCalculateMonthlyPayment() {
        LoanCalculator calculator = new LoanCalculator();
    
        // Berechnung der erwarteten Rate mit der präziseren Methode
        double expected = 438.71;
        double actual = calculator.calculateMonthlyPayment(10000, 5, 2);
    
        assertEquals(expected, actual, 0.01);
    }
    
}
