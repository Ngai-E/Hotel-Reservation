/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.model;


/**
 *
 * @author E.Ngai
 */
public class FreeRoom extends Room{
    private Double price;
    
    public FreeRoom() {
        this.price = new Double(0);
    }
    
    @Override
    public String toString() {
        return "Room #" + getRoomNumber() + "FREE - " + getRoomType().name() ;
    }
    
}
