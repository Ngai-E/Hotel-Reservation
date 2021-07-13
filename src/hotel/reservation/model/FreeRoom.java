/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.model;


import hotel.reservation.model.types.RoomType;

/**
 *
 * @author E.Ngai
 */
public class FreeRoom extends Room{
    private Double price;
    
    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, Double.valueOf(0), roomType);
        this.price = super.getRoomPrice();
    }
    
    @Override
    public String toString() {
        return "Room #" + getRoomNumber() + "FREE - " + getRoomType().name() ;
    }
    
}
