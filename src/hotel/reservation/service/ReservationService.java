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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author E.Ngai
 */
public class ReservationService {
    private static ReservationService reservationService;
    private static List<Reservation> reservations = new ArrayList<>();
    private static Set<IRoom> rooms = new HashSet<>();
    
    public void addRoom(IRoom room){
        rooms.add(room);
    }
    
    public IRoom getARoom(String roomId){
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().getRoomNumber().equals(roomId))
                return reservation.getRoom();
        }
        return null;
    }
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().equals(room) && checkInDate.after(reservation.getCheckInDate()) && checkInDate.before(reservation.getCheckOutDate())){
                System.out.println("ROOM ALREADY OCCUPIED");
                return null;
            }
                
        }
        Reservation newReservation  = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(newReservation);
        
        return newReservation;
    }
    
//    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
//        List<IRoom> availableRooms = new ArrayList<>();
//        List<IRoom> recommendedRooms = new ArrayList<>();
//        List<IRooms> allRooms = 
//        Calendar calendar = Calendar.getInstance();
//        for (Reservation reservation : reservations) {
//            if (reservation.)
//        }
//        
//        
//    }
//    
//    public Collection<Reservation> getCustomersReservation(Customer customer){}
    public void printAllReservation(){}
    
    public ReservationService getInstance() {
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
