/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.UI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author E.Ngai
 */
public class AdminMenu {

    private static List<String> menuItems = new ArrayList<String>() {
        {
            add("See all Customers");
            add("See all Rooms");
            add("See all Reservations");
            add("Add a Room");
            add("Back to Main Menu");
        }
    };

    public static void printAdminMenu() {
        int i = 1;
        for (String menuItem : menuItems) {
            System.out.printf("%s. %s\n", i++ + "", menuItem);
        }
    }

    public static String getMenuItemAtIndex(int index) {
        return menuItems.get(index);
    }
}
