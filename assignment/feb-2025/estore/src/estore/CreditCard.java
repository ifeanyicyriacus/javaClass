package estore;

public class CreditCard {
    private int cvv;
    private int expirationYear;
    private int expirationMonth;
    private String cardNumber;
    private String name;
    private CardType cardType;

    public CreditCard(int cvv, int expirationYear, int expirationMonth, String cardNumber, String name, CardType type) {
        this.cvv = cvv;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
        this.cardNumber = cardNumber;
        this.name = name;
        this.cardType = type;
    }
}
