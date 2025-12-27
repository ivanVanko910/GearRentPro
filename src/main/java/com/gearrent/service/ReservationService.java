package com.gearrent.service;

import com.gearrent.dao.ReservationDAO;
import com.gearrent.entity.Reservation;
import com.gearrent.dao.RentalDAO;
import com.gearrent.util.DateUtils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ReservationService {
    
    private ReservationDAO reservationDAO;
    private RentalDAO rentalDAO;
    private static ReservationService instance;
    private static final int MAX_RENTAL_DAYS = 30;
    
    private ReservationService() {
        this.reservationDAO = new ReservationDAO();
        this.rentalDAO = new RentalDAO();
    }
    
    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }
    
    /**
     * Get all reservations
     */
    public List<Reservation> getAllReservations() throws SQLException {
        return reservationDAO.getAllReservations();
    }
    
    /**
     * Get reservation by ID
     */
    public Reservation getReservationById(int reservationId) throws SQLException {
        return reservationDAO.getReservationById(reservationId);
    }
    
    /**
     * Create reservation with validation
     */
    public boolean createReservation(Reservation reservation, int customerId) throws SQLException {
        validateReservation(reservation);
        
        // Check for overlapping reservations and rentals
        if (hasDateConflict(reservation.getEquipmentId(), reservation.getStartDate(), 
                           reservation.getEndDate())) {
            throw new IllegalArgumentException("Equipment not available for selected dates!");
        }
        
        // Check customer deposit limit
        CustomerService customerService = CustomerService.getInstance();
        if (!isCustomerDepositLimitValid(customerId, reservation)) {
            throw new IllegalArgumentException("Customer deposit limit would be exceeded!");
        }
        
        // Generate reservation code
        reservation.setReservationCode("RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        
        int reservationId = reservationDAO.createReservation(reservation);
        return reservationId > 0;
    }
    
    /**
     * Cancel reservation
     */
    public boolean cancelReservation(int reservationId) throws SQLException {
        return reservationDAO.updateReservationStatus(reservationId, Reservation.ReservationStatus.CANCELLED);
    }
    
    public List<Reservation> getReservationsByBranch(int branchId) throws SQLException {
        return reservationDAO.getReservationsByBranch(branchId);
    }

    public boolean updateReservationStatus(int reservationId, Reservation.ReservationStatus status) throws SQLException {
        return reservationDAO.updateReservationStatus(reservationId, status);
    }

    /**
     * Validate reservation data
     */
    private void validateReservation(Reservation reservation) throws IllegalArgumentException {
        if (reservation.getStartDate() == null || reservation.getEndDate() == null) {
            throw new IllegalArgumentException("Start and end dates are required!");
        }
        
        if (reservation.getStartDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Reservation cannot be in the past!");
        }
        
        if (reservation.getEndDate().isBefore(reservation.getStartDate())) {
            throw new IllegalArgumentException("End date must be after start date!");
        }
        
        int days = DateUtils.getDaysBetween(reservation.getStartDate(), reservation.getEndDate());
        if (days > MAX_RENTAL_DAYS) {
            throw new IllegalArgumentException("Reservation duration cannot exceed 30 days!");
        }
    }
    
    /**
     * Check if equipment has date conflicts
     */
    private boolean hasDateConflict(int equipmentId, LocalDate startDate, LocalDate endDate) throws SQLException {
        // Check reservations
        if (reservationDAO.hasOverlappingReservation(equipmentId, startDate, endDate)) {
            return true;
        }
        
        // Check rentals (from RentalDAO)
        return rentalDAO.isEquipmentRented(equipmentId, startDate, endDate);
    }
    
    /**
     * Check if customer deposit limit is valid
     */
    private boolean isCustomerDepositLimitValid(int customerId, Reservation reservation) throws SQLException {
        // This will be implemented when we add deposit calculation
        return true;
    }
}