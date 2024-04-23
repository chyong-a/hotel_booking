package test;

import model.Room;
import model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {

    private Room room;

    @BeforeEach
    public void setup() {
        this.room = new Room(1);
    }

    @Test
    public void book_noReservations_returnsSUCCESSFUL() {
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);

        assertEquals(Status.SUCCESSFUL, this.room.book(checkIn, checkOut));
    }

    @Test
    public void book_reservedOnGivenDates_returnsUNSUCCESSFUL() {
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);
        this.room.book(checkIn, checkOut);
        assertEquals(Status.UNSUCCESSFUL, this.room.book(checkIn, checkOut));
    }

    @Test
    public void book_overlapOfGivenCheckInDateAndReservedDates_returnsUNSUCCESSFUL() {
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);
        this.room.book(checkIn, checkOut);
        assertEquals(Status.UNSUCCESSFUL, this.room.book(checkIn, checkOut.minusDays(5)));
    }

    @Test
    public void book_overlapOfGivenCheckOutDateAndReservedDates_returnsUNSUCCESSFUL() {
        LocalDate checkIn = LocalDate.of(2024, 04, 10);
        LocalDate checkOut = LocalDate.of(2024, 04, 24);
        this.room.book(checkIn, checkOut);
        assertEquals(Status.UNSUCCESSFUL, this.room.book(checkIn.plusDays(5), checkOut));
    }
}
