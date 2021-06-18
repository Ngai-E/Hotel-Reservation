/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.service;

import hotel.reservation.model.Customer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author E.Ngai
 */
public class CustomerService {

    private final Map<String, Customer> CUSOTMERS = new HashMap<>();
    private static CustomerService customerService;


    public void addCustomer(String email, String firstName, String lastName) {
        try {
            CUSOTMERS.put(email, new Customer(firstName, lastName, email));
        } catch (Exception e) {
            System.out.println("FAILED CREATING CUSTOMER");
        }
    }
    
    public Customer getCustomer(String customerEmail) {
        return CUSOTMERS.getOrDefault(customerEmail, null);
    }
    
    public Collection<Customer> getAllCustomers() {
        return CUSOTMERS.values();
    }
    
    public static CustomerService getInstance() {
        if (customerService == null) {
            synchronized (CustomerService.class) {
                if (customerService == null) {
                    customerService = new CustomerService();
                    return customerService;
                }
            }
        }
        return customerService;
    }
}
