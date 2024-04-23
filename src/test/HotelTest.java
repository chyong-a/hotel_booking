package test;

import model.Hotel;
import model.NonExistentRoomException;
import model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

public class HotelTest {

    private Hotel hotel;

    @BeforeEach
    public void setup() {
        this.hotel = new Hotel(2);
    }

    @Test
    public void book_emptyRooms_returnsSUCCESSFUL() throws NonExistentRoomException {
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);

        assertEquals(Status.SUCCESSFUL, this.hotel.book(1, checkIn, checkOut));
        assertEquals(Status.SUCCESSFUL, this.hotel.book(2, checkIn, checkOut));
    }

    @Test
    public void book_roomReservedAtGivenDates_returnsUNSUCCESSFUL() throws NonExistentRoomException {
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);
        this.hotel.book(1, checkIn, checkOut);
        assertEquals(Status.UNSUCCESSFUL, this.hotel.book(1, checkIn, checkOut));
    }

    @Test
    public void book_checkInDateOverlaps_returnsUNSUCCESSFUL() throws NonExistentRoomException {
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);
        this.hotel.book(1, checkIn, checkOut);
        assertEquals(Status.UNSUCCESSFUL, this.hotel.book(1, checkIn.plusDays(5), checkOut));
    }

    @Test
    public void book_checkOutDateOverlaps_returnsUNSUCCESSFUL() throws NonExistentRoomException {
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);
        this.hotel.book(1, checkIn, checkOut);
        assertEquals(Status.UNSUCCESSFUL, this.hotel.book(1, checkIn, checkOut.minusDays(5)));
    }

    @Test
    public void book_nonexistentRoom_throwsNonExistentRoomException(){
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);
        assertThrows(NonExistentRoomException.class, () -> this.hotel.book(3, checkIn, checkOut));
    }
}
