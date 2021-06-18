/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation;

import hotel.reservation.model.Customer;

/**
 *
 * @author E.Ngai
 */
public class HotelReservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Customer customer = new Customer("first", "second", "j@domain.com");
        System.out.println(customer);
        Customer customer2 = new Customer("first", "second", "email");
    }
    
}
