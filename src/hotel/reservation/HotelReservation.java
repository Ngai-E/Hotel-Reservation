/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation;

import hotel.reservation.UI.MainMenu;
import hotel.reservation.model.Customer;
import java.util.Scanner;

/**
 *
 * @author E.Ngai
 */
public class HotelReservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            Customer customer = new Customer("first", "second", "j@domain.com");
//            Customer customer2 = new Customer("first", "second", "email");
//        } catch (Exception e) {
//        }

        System.out.println("**********WELCOME TO HOTEL LAGOON********");

        MainMenu.printMainMenu();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            switch (scanner.next()) {
                case "1":
                       System.out.printf("******** %s ********", MainMenu.getMenuItemAtIndex(0));
                    break;
                case "2":
                       System.out.printf("******** %s ********", MainMenu.getMenuItemAtIndex(1));
                    break;
                case "3":
                       System.out.printf("******** %s ********", MainMenu.getMenuItemAtIndex(2));
                    break;
                case "4":
                       System.out.printf("******** %s ********", MainMenu.getMenuItemAtIndex(3));
                    break;
                case "5":
                default:
                    exit = true;
            }
        } while (!exit);

        System.out.println("**********THANKS FOR BOOKING WITH US********");
    }

}
