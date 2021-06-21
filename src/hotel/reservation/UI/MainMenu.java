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
public class MainMenu {
    private static List<String> menuItems = new ArrayList<String>() {{
        add("Find and reserve a room");
        add("See my reservations");
        add("Create an account");
        add("Admin");
        add("Exit");
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
