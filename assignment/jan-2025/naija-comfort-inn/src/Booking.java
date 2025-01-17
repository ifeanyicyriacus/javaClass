import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Booking {
    private final UUID  bookingID;
    private final Room  room;
    private final Guest guest;
    private Date  checkInDate;
    private Date checkOutDate;
    private BookingStatus bookingStatus;
    private Date bookingDate;
    private BigDecimal totalPrice;

    public Booking(UUID bookingID, Room room, Guest guest) {
        this.bookingID = bookingID;
        this.room = room;
        this.guest = guest;

    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public enum BookingStatus {
        PENDING, CONFIRMED, CANCELLED
    }

    public UUID getBookingID() {
        return bookingID;
    }


    @Override
    public String toString(){
        return "";
    }


}
