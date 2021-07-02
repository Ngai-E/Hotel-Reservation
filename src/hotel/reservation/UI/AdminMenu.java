/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.UI;

import hotel.reservation.utils.CommonMessages;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author E.Ngai
 */
public class AdminMenu {

    private static List<String> menuItems = new ArrayList<String>() {
        {
            add(CommonMessages.SEE_ALL_CUSTOMERS);
            add(CommonMessages.SEE_ALL_ROOMS);
            add(CommonMessages.SEE_ALL_RESERVATION);
            add(CommonMessages.ADD_A_ROOM);
            add(CommonMessages.BACK_TO_MAIN_MENU);
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
