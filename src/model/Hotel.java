package model;

import java.time.LocalDate;

import static model.Status.SUCCESSFUL;
import static model.Status.UNSUCCESSFUL;

public class Hotel {
    private Room[] hotel;

    /**
     * Public constructor accepting capacity
     * @param capacity
     */
    public Hotel(int capacity){
        this.hotel = new Room[capacity];
        for (int i = 0; i < capacity; i++){
            this.hotel[i] = new Room(i+1);
        }
    }

    /**
     * Public constructor accepting array of rooms
     * @param hotel
     */
    public Hotel(Room[] hotel){
        this.hotel = hotel;
    }

    /**
     * Books a room for the given check-in and check-out dates; Returns SUCCESSFUL if success, otherwise, UNSUCCESSFUL
     * @param roomNumber
     * @param checkIn
     * @param checkOut
     * @return
     */
    public Status book(int roomNumber,  LocalDate checkIn, LocalDate checkOut) throws NonExistentRoomException {
        Room room = null;
        room = findRoom(roomNumber);
        return room.book(checkIn, checkOut);
    }

    /**
     * Returns a room with a given number; If not found, throws an NonExistentRoomException exception
     * @param roomNumber
     * @return
     * @throws NonExistentRoomException
     */
    private Room findRoom(int roomNumber) throws NonExistentRoomException {
        for (Room room : this.hotel){
            if (room.getNumber() == roomNumber){
                return room;
            }
        }
        throw new NonExistentRoomException("There is no room under such a number.");
    }
}
