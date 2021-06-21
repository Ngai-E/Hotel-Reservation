/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.api;

import hotel.reservation.model.Customer;
import hotel.reservation.model.IRoom;
import hotel.reservation.model.Reservation;
import hotel.reservation.service.CustomerService;
import hotel.reservation.service.ReservationService;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author E.Ngai
 */
public class HotelResource {
        private static HotelResource hotelResource;
        private CustomerService customerService;
        private ReservationService reservationService;
        
        public HotelResource() {
            customerService = CustomerService.getInstance();
            reservationService = ReservationService.getInstance();
        }
        
        public Customer getCustomer(String email) {
            return customerService.getCustomer(email);
        }
        
        public void createACustomer(String email, String firstName, String lastName){
            customerService.addCustomer(email, firstName, lastName);
        }
        
        public IRoom getRoom(String roomNumber){
            return reservationService.getARoom(roomNumber);
        }
        
        public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate){
            Customer customer = customerService.getCustomer(customerEmail);
            return reservationService.reserveARoom(customer, room, checkInDate, CheckOutDate);
        }
        
        public Collection<Reservation> getCustomersReservations(String customerEmail){
            Customer customer = customerService.getCustomer(customerEmail);
            return reservationService.getCustomersReservation(customer);
        }
        
        public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
            return reservationService.findRooms(checkIn, checkOut);
        }
        
        public HotelResource getInstance() {
        if (hotelResource == null) {
            synchronized (HotelResource.class) {
                if (hotelResource == null) {
                    hotelResource = new HotelResource();
                    return hotelResource;
                }
            }
        }

        return hotelResource;
    }
    
}
