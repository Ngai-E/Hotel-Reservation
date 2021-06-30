/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation;

import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hotel.reservation.UI.MainMenu;
import hotel.reservation.api.AdminResource;
import hotel.reservation.api.HotelResource;
import hotel.reservation.model.Customer;
import hotel.reservation.model.IRoom;
import hotel.reservation.model.Reservation;
import hotel.reservation.utils.CommonMessages;
import hotel.reservation.utils.PatternsString;
import hotel.reservation.utils.Utilities;

/**
 *
 * @author E.Ngai
 */
public class HotelReservation {
    static  HotelResource hotelResource = HotelResource.getInstance();
    static  AdminResource adminResource = AdminResource.getInstance();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        presentHotelPrompt();
    }

    //<editor-fold defaultstate="collapsed" desc="[ PRIVATE METHODS ]">

    private static void presentHotelPrompt() {
        System.out.println(CommonMessages.WELCOME_MESSAGE);

        MainMenu.printMainMenu();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            switch (scanner.next()) {
                case "1":
                       System.out.printf("******** %s ********", MainMenu.getMenuItemAtIndex(0));
                       findRoom();
                    break;
                case "2":
                       System.out.printf("******** %s ********", MainMenu.getMenuItemAtIndex(1));
                       seeReservations();
                    break;
                case "3":
                       System.out.printf("******** %s ********", MainMenu.getMenuItemAtIndex(2));
                       createAccount();
                    break;
                case "4":
                       System.out.printf("******** %s ********", MainMenu.getMenuItemAtIndex(3));
                    break;
                case "5":
                default:
                    exit = true;
            }
        } while (!exit);

        System.out.println(CommonMessages.GOODBYE_MESSAGE);
    }

    private static void seeReservations() {
        String customerEmail = null;
        customerEmail = getCustomerInfo(customerEmail);
        Collection<Reservation> reservations = hotelResource.getCustomersReservations(customerEmail);

        for (Reservation reservation: reservations) {
            System.out.println(reservation.toString());
        }
    }

    private static String getCustomerInfo(String customerEmail) {
        String[] instructions = new String[]{
                CommonMessages.ENTER_EMAIL
        };

        Scanner scanner = new Scanner(System.in);
        String input;
        for (int i = 0; i < instructions.length; i++) {
            System.out.println("\n" + instructions[i]);

            input = scanner.next();
            if (!Utilities.isValidEmail(input)) {
                i--;
                System.out.println(CommonMessages.INVALID_EMAIL);
                continue;
            }

            switch (i) {
                case 0:
                    customerEmail = input;
                    break;
            }
        }
        Customer customer = hotelResource.getCustomer(customerEmail);
        if (customer == null) {
            System.out.println(CommonMessages.ERROR_ACCOUNT_DOES_NOT_EXIST);
            presentHotelPrompt();
        }
        return customerEmail;
    }

    private static void findRoom() {
        String checkInDate = null;
        String checkoutDate = null;
        int recommendSearchDays = -1;

        String[] roomInstructions = new String[]{
                CommonMessages.ENTER_CHECKIN_DATE,
                CommonMessages.ENTER_CHECKOUT_DATE,
                CommonMessages.ENTER_RECOMMENDED_SEARCH_DAYS
        };

        Scanner scanner = new Scanner(System.in);
        String input;

        for (int i = 0; i < roomInstructions.length; i++) {
            System.out.println("\n" +roomInstructions[i]);

            input = scanner.next();

            if (input.equals(CommonMessages.EMPTY_STRING) && i != 2){
                System.out.println(CommonMessages.INVALID_INPUT_CANNOT_BE_EMPTY);
                i--;
                continue;
            }

            switch (i) {
                case 0:
                    if (!Utilities.isValidDateStringSlashSeparated(input)) {
                        System.out.println(CommonMessages.INVALID_INPUT_DATE);
                        i--;
                        break;
                    }
                    checkInDate = input;
                    break;
                case 1:
                    if (!Utilities.isValidDateStringSlashSeparated(input)) {
                        System.out.println(CommonMessages.INVALID_INPUT_DATE);
                        i--;
                        break;
                    }
                    checkoutDate = input;
                    break;
                case 2:
                    if (!Utilities.isValidNumber(input)) {
                        System.out.println(CommonMessages.INVALID_INPUT_MUST_BE_A_NUMBER);
                        i--;
                        break;
                    }
                    recommendSearchDays = Integer.parseInt(input);

                    if (recommendSearchDays < 0) {
                        System.out.println(CommonMessages.INVALID_INPUT_NON_NEGATIVE);
                        i--;
                        break;
                    }
                    break;
            }
        }
        try {
            Date chckinDate = Utilities.getDateFormatter().parse(checkInDate);
            Date chckoutDate = Utilities.getDateFormatter().parse(checkoutDate);

            Collection<IRoom> rooms = hotelResource.findARoom(chckinDate, chckoutDate);

            for (IRoom room : rooms) {
                System.out.println(room.toString());
            }

        } catch (Exception ex) {
            System.out.println(CommonMessages.ERROR_SYSTEM_ERROR);
        }

        presentHotelPrompt();

    }

    private static  void createAccount() {
        String email = null;
        String lastname = null;
        String firstName = null;

        String[] instructions = new String[]{
                CommonMessages.ENTER_FIRSTNAME,
                CommonMessages.ENTER_LASTNAME,
                CommonMessages.ENTER_EMAIL
        };

        Scanner scanner = new Scanner(System.in);
        String input;
        for (int i = 0; i < instructions.length; i++) {
            System.out.println("\n" + instructions[i]);
            input = scanner.next();
            if (input.equals(CommonMessages.EMPTY_STRING)) {
                System.out.println(CommonMessages.INVALID_INPUT_CANNOT_BE_EMPTY);
                i--;
                continue;
            }
            switch (i){
                case 0:
                    firstName = input;
                    break;
                case 1:
                    lastname = input;
                    break;
                case 2:
                    email = input;
                    break;
            }
        }

        hotelResource.createACustomer(email, firstName, lastname);

        presentHotelPrompt();
    }

    //</editor-fold>
}
