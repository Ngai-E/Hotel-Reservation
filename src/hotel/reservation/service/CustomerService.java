/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.service;

import hotel.reservation.model.Customer;
import hotel.reservation.utils.CommonMessages;
import hotel.reservation.utils.Utilities;

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
            System.out.println(CommonMessages.CUSTOMER_CREATED);
        } catch (Exception e) {
            System.out.println(CommonMessages.CUSTOMER_CREAT_FAILED);
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
