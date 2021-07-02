/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.reservation.model;

import hotel.reservation.model.types.RoomType;
import java.util.Objects;
/**
 *
 * @author E.Ngai
 */
public class Room implements IRoom{
    
    private String roomNumber;
    private Double price;
    private RoomType roomType;

    public Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }
    
    @Override
    public String toString() {
        return "Room #" + roomNumber + ", price is " + price + " - " + roomType.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() != getClass()) return false;
        
        Room room = (Room) o;
        return roomNumber.equals(room.getRoomNumber()) && price.equals(room.getRoomPrice()) && roomType.equals(room.getRoomType());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.roomNumber);
        hash = 59 * hash + Objects.hashCode(this.price);
        hash = 59 * hash + Objects.hashCode(this.roomType);
        return hash;
    }
    
}
