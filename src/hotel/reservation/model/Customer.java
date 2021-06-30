/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.model;

import hotel.reservation.utils.PatternsString;
import hotel.reservation.utils.PatternsString;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author E.Ngai
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    private static final Pattern pattern = Pattern.compile(PatternsString.EMAIL_PATTERN);
    
    public Customer(String firstname, String lastname, String email) {
        Matcher matcher = pattern.matcher(email);
        
        if (!matcher.find()) throw new IllegalArgumentException();
        this.email = email;
        this.lastName = lastname;
        this.firstName = firstname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String toString() {
        return firstName + " " + lastName + " " + email;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() != getClass()) return false;
        
        Customer customer = (Customer) o;
        return firstName.equals(customer.getFirstName()) && lastName.equals(customer.getLastName()) && email.equals(customer.getEmail());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.email);
        return hash;
    }
}
