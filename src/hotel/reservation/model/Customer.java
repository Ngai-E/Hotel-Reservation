/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.model;

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
    
    private static final String EMAIL_PATTERN = "^(.+)@(.+).(.+)$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    
    public Customer(String firstname, String lastname, String email) {
        Matcher matcher = pattern.matcher(email);
        
        if (!matcher.find()) throw new IllegalArgumentException();
        this.email = email;
        this.lastName = lastname;
        this.firstName = firstname;
    }
    public String toString() {
        return firstName + " " + lastName + " " + email;
    }
}
