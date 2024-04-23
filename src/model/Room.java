package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static model.Status.SUCCESSFUL;
import static model.Status.UNSUCCESSFUL;

public class Room {
    private int number;
    private List <LocalDate> bookedDates;

    /**
     * Public constructor
     * @param number
     */
    public Room (int number){
        this.number = number;
        this.bookedDates = new LinkedList<>();
    }

    /**
     * Gets a number of the room
     * @return
     */
    public int getNumber(){
        return this.number;
    }

    /**
     * Books a room for given check-in and check-out dates
     * @param checkIn
     * @param checkOut
     */
    public Status book(LocalDate checkIn, LocalDate checkOut){
        if (!isBookedWithinDates(checkIn, checkOut)){
            LocalDate date = checkIn;
            while (!date.equals(checkOut)){
                this.bookedDates. add(date);
                date = date.plusDays(1);
            }
            return SUCCESSFUL;
        }
        return UNSUCCESSFUL;
    }

    /**
     * Checks if the room is booked within the given check-in and check-out dates
     * @param checkIn
     * @param checkOut
     * @return
     */
    private boolean isBookedWithinDates(LocalDate checkIn, LocalDate checkOut) {
        for (LocalDate bookedDate : this.bookedDates) {
            if (bookedDate.isBefore(checkOut) && bookedDate.isAfter(checkIn) || bookedDate.equals(checkIn) || bookedDate.equals(checkOut)) {
                return true;
            }
        }
        return false;
    }

}
