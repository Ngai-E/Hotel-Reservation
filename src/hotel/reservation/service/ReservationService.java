/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.service;

import hotel.reservation.model.Customer;
import hotel.reservation.model.IRoom;
import hotel.reservation.model.Reservation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author E.Ngai
 */
public class ReservationService {

    private static ReservationService reservationService;
    private static List<Reservation> reservations = new ArrayList<>();
    private static Map<String, IRoom> rooms = new HashMap();
    
    private static final int RECOMMENDED_SEARCH_DAYS = 7;

    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId) {
        return rooms.getOrDefault(roomId, null);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().equals(room) && checkInDate.after(reservation.getCheckInDate()) && checkInDate.before(reservation.getCheckOutDate())) {
                System.out.println("ROOM ALREADY OCCUPIED");
                return null;
            }
        }
        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(newReservation);

        return newReservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> availableRooms = rooms.values();
        Collection<IRoom> recommendedRooms = rooms.values();
        
        Calendar calendarCheckin = Calendar.getInstance();
        IRoom room;
        
        for (Reservation reservation : reservations) {
            room = reservation.getRoom();
            if (checkInDate == reservation.getCheckInDate() || (checkInDate.after(reservation.getCheckInDate()) && checkInDate.before(reservation.getCheckOutDate()))) {
                availableRooms.remove(room);
                recommendedRooms.remove(room);
            }
            
            calendarCheckin.add(Calendar.DAY_OF_MONTH, RECOMMENDED_SEARCH_DAYS);
            calendarCheckin.setTime(checkInDate);
            
            System.out.println(calendarCheckin + "***");
            if (calendarCheckin.after(reservation.getCheckInDate()) && calendarCheckin.before(reservation.getCheckOutDate())) {
                recommendedRooms.remove(room);
            }
        }
        
        return availableRooms.size() > 0 ? availableRooms : recommendedRooms;
    }
    
    public Collection<Reservation> getCustomersReservation(Customer customer) {
        List<Reservation> customerReservation = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) {
                customerReservation.add(reservation);
            }
        }

        return customerReservation;
    }

    public void printAllReservation() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
    
    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    public static ReservationService getInstance() {
        if (reservationService == null) {
            synchronized (ReservationService.class) {
                if (reservationService == null) {
                    reservationService = new ReservationService();
                    return reservationService;
                }
            }
        }

        return reservationService;
    }
}
