package estore;

public class Billing {
    private String receiverName;
    private String receiverPhoneNumber;
    private Address deliveryAddress;
    private CreditCard creditCardInformation;

    public Billing(String receiverName, String receiverPhoneNumber, Address deliveryAddress, CreditCard creditCardInformation) {
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.deliveryAddress = deliveryAddress;
        this.creditCardInformation = creditCardInformation;

    }
}
