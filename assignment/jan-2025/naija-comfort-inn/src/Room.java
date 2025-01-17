import java.math.BigDecimal;
import java.util.UUID;

public class Room {
    private final UUID     ID;
    private final Hotel hotel;
    private String   number;
    private RoomType   type;
//    private BedType bedType;
    private BigDecimal price;
    private Status     status;
    private Amenities[] amenities;
    private String description;

    public Room(UUID ID, Hotel hotel) {
        this.ID = ID;
        this.hotel = hotel;
    }

    public UUID getID() {
        return ID;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

//    public BedType getBedType() {
//        return bedType;
//    }
//
//    public void setBedType(BedType bedType) {
//        this.bedType = bedType;
//    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Amenities[] getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities[] amenities) {
        this.amenities = amenities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum RoomType {
        SINGLE, DOUBLE, SUITE
    }

    public enum Status {
        AVAILABLE, OCCUPIED, UNDER_MAINTENANCE
    }

    public enum Amenities {
        WIFI, TV, MINIBAR,
    }

//    public enum BedType{
//        KING, QUEEN, TWIN
//    }


    @Override
    public String toString() {
        return "";

    }
}


//use random choices to generate 100 rooms