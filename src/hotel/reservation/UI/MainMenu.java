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
public class MainMenu {
    private static List<String> menuItems = new ArrayList<String>() {{
        add(CommonMessages.FIND_A_ROOM);
        add(CommonMessages.SEE_RESERVATIONS);
        add(CommonMessages.CREATE_ACCOUNT);
        add(CommonMessages.ADMIN);
        add(CommonMessages.EXIT);
    }};
    
    public static void printMainMenu() {
        int i = 1;
        for (String menuItem : menuItems) {
            System.out.printf("%s. %s\n", i++ + "", menuItem);
        }
    }
    
    public static String getMenuItemAtIndex(int index) {
        return menuItems.get(index);
    }
}
