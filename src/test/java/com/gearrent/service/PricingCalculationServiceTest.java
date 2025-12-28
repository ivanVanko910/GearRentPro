package com.gearrent.service;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PricingCalculationServiceTest {

    private final PricingCalculationService pricingCalculationService = PricingCalculationService.getInstance();

    @Test
    public void testCalculateLongRentalDiscount() {
        BigDecimal rentalAmount = new BigDecimal("1000.00");
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 8);
        BigDecimal discount = pricingCalculationService.calculateLongRentalDiscount(rentalAmount, startDate, endDate);
        assertEquals(new BigDecimal("100.00"), discount);
    }

    @Test
    public void testCalculateLateFee() {
        LocalDate endDate = LocalDate.of(2024, 1, 1);
        LocalDate actualReturnDate = LocalDate.of(2024, 1, 3);
        BigDecimal dailyLateFee = new BigDecimal("50.00");
        BigDecimal lateFee = pricingCalculationService.calculateLateFee(endDate, actualReturnDate, dailyLateFee);
        assertEquals(new BigDecimal("100.00"), lateFee);
    }
}
