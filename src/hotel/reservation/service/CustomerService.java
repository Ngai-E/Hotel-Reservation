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

    private static final Map<String, Customer>  CUSTOMERS = new HashMap<>();
    private static CustomerService customerService;


    public void addCustomer(String email, String firstName, String lastName) {
        try {
            CUSTOMERS.put(email, new Customer(firstName, lastName, email));
            System.out.println(CommonMessages.CUSTOMER_CREATED);
        } catch (Exception e) {
            System.out.println(CommonMessages.CUSTOMER_CREAT_FAILED);
        }
    }
    
    public Customer getCustomer(String customerEmail) {
        return CUSTOMERS.getOrDefault(customerEmail, null);
    }
    
    public Collection<Customer> getAllCustomers() {
        return CUSTOMERS.values();
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
