/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.api;

import hotel.reservation.model.Customer;
import hotel.reservation.model.IRoom;
import hotel.reservation.service.CustomerService;
import hotel.reservation.service.ReservationService;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author E.Ngai
 */
public class AdminResource {

    private AdminResource adminResource;
    private CustomerService customerService;
    private ReservationService reservationService;

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }
    
    public void addRoom(List<IRoom> rooms) {
        for (IRoom room : rooms) {
            reservationService.addRoom(room);
        }
    }
    
    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }
    
    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    
    public void displayAllReservations(){
        reservationService.printAllReservation();
    }

    public AdminResource getInstance() {
        if (adminResource == null) {
            synchronized (AdminResource.class) {
                if (adminResource == null) {
                    adminResource = new AdminResource();
                    return adminResource;
                }
            }
        }

        return adminResource;
    }

}
