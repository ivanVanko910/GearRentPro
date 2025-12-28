package com.gearrent.service;

import com.gearrent.dao.RentalDAO;
import com.gearrent.entity.Customer;
import com.gearrent.entity.Rental;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collections;

import static org.mockito.Mockito.when;

public class RentalServiceTest {

    @Mock
    private RentalDAO rentalDAO;

    @InjectMocks
    private RentalService rentalService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckCustomerDepositLimit() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setDepositLimit(new BigDecimal("1000.00"));

        Rental activeRental = new Rental();
        activeRental.setSecurityDeposit(new BigDecimal("500.00"));

        when(rentalDAO.getActiveRentalsByCustomer(1)).thenReturn(Collections.singletonList(activeRental));

        rentalService.createRental(new Rental(), null, customer, null);
    }
}
