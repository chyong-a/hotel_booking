import model.Hotel;
import model.NonExistentRoomException;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Hotel hotel = new Hotel(2);

        LocalDate checkIn1 = LocalDate.of(2024, 04, 10);
        LocalDate checkOut1 = LocalDate.of(2024, 04, 15);
        LocalDate checkIn2 = LocalDate.of(2024, 04, 12);
        LocalDate checkOut2 = LocalDate.of(2024, 04, 18);

        try {
            System.out.println("Booking room 1: " + hotel.book(1, checkIn1, checkOut1));
        } catch (NonExistentRoomException e) {
            System.out.println("Error booking room 1: " + e.getMessage());
        }

        try {
            System.out.println("Booking room 1 again: " + hotel.book(1, checkIn2, checkOut2));
        } catch (NonExistentRoomException e) {
            System.out.println("Error booking room 1 again: " + e.getMessage());
        }

        try {
            System.out.println("Booking room 2: " + hotel.book(2, checkIn1, checkOut1));
        } catch (NonExistentRoomException e) {
            System.out.println("Error booking room 2: " + e.getMessage());
        }

        try {
            System.out.println("Booking room 3: " + hotel.book(3, checkIn1, checkOut1));
        } catch (NonExistentRoomException e) {
            System.out.println("Error booking room 3: " + e.getMessage());
        }
    }
}
