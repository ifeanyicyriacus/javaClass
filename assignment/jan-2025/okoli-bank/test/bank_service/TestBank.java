package bank_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBank {
    private       Bank     bank;
    private final String[] firstNames = {"John", "Ifeanyi"};
    private final String[] lastNames  = {"Doe","Mark"};
    private final String[] pins = {"1234", "0000"};


    @BeforeEach
    void setUp() {
        bank = new Bank("First Bank Nigeria");
    }

    @Test
    public void testBank_exist() {
        assertTrue(bank.exist());
        assertEquals("First Bank Nigeria", bank.getName());
    }

    @Test
    public void testBank_canCreateAccount() {
        int numberOfAccountsInBank = bank.getNumberOfAccounts();
        int accountNumber = bank.createAccount(firstNames[0], lastNames[0], pins[0]);
        assertEquals(firstNames[0], bank.getAccountFirstName(accountNumber));
        assertEquals(lastNames[0], bank.getAccountLastName(accountNumber));
        assertEquals(0, bank.checkBalance(accountNumber, pins[0]));
        assertEquals(numberOfAccountsInBank + 1, bank.getNumberOfAccounts());
    }

    @Test
    public void testBank_canDepositIntoAnAccount() {
        int accountNumber1 = bank.createAccount(firstNames[0], lastNames[0], pins[0]);

        bank.deposit(accountNumber1, 100_000);
        assertEquals(100_000, bank.checkBalance(accountNumber1, pins[0]));

        int accountNumber2 = bank.createAccount(firstNames[1], lastNames[1], pins[1]);
        bank.deposit(accountNumber2, 150_000);
        assertEquals(150_000, bank.checkBalance(accountNumber2, pins[1]));
    }

    @Test
    public void testBank_canAcceptWithdrawWhenBalanceIsMoreThanAmount() {
        String pin = pins[0];
        int accountNumber = bank.createAccount(firstNames[0], lastNames[0], pin);
        assertEquals(0, bank.checkBalance(accountNumber, pin));
        bank.deposit(accountNumber,10_000);
        bank.withdraw(accountNumber, 9_000, pin);
        assertEquals(1_000, bank.checkBalance(accountNumber, pin));
    }

    @Test
    public void testBank_canEnableMoneyTransfer() {
        String pin1 = pins[0];
        String pin2 = pins[1];
        int accountNumber1 = bank.createAccount(firstNames[0], lastNames[0], pin1);
        int accountNumber2 = bank.createAccount(firstNames[1], lastNames[1], pin2);

        bank.deposit(accountNumber1, 150_000);
        assertEquals(150_000, bank.checkBalance(accountNumber1, pin1));
        assertEquals(0, bank.checkBalance(accountNumber2, pin2));

        bank.transfer(accountNumber1, accountNumber2, 50_000, pin1);
        assertEquals(100_000, bank.checkBalance(accountNumber1, pin1));
        assertEquals(50_000, bank.checkBalance(accountNumber2, pin2));

        bank.transfer(accountNumber2, accountNumber1, 8_000, pin2);
        assertEquals(108_000, bank.checkBalance(accountNumber1, pin1));
        assertEquals(42_000, bank.checkBalance(accountNumber2, pin2));
    }

    @Test
    public void testBank_transferRevertToOriginalStateWhenSenderPinIsIncorrect() {
        String correctSenderPin = pins[0];
        String correctReceiverPin = pins[1];
        String incorrectSenderPin = "incorrect";

        int senderAccountNumber =  bank.createAccount(firstNames[0], lastNames[0], correctSenderPin);
        int receiverAccountNumber =  bank.createAccount(firstNames[1], lastNames[1], correctReceiverPin);

        bank.deposit(senderAccountNumber, 150_000);
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
        assertEquals(0, bank.checkBalance(receiverAccountNumber, correctReceiverPin));

        assertThrowsExactly(IllegalArgumentException.class,
                ()-> bank.transfer(senderAccountNumber, receiverAccountNumber, 50_000, incorrectSenderPin));
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
        assertEquals(0, bank.checkBalance(receiverAccountNumber, correctReceiverPin));
    }

    @Test
    public void testBank_transferRevertToOriginalStateWhenSenderAccountNumberIsIncorrect(){
        String correctSenderPin = pins[0];
        String correctReceiverPin = pins[1];

        int senderAccountNumber =  bank.createAccount(firstNames[0], lastNames[0], correctSenderPin);
        int receiverAccountNumber =  bank.createAccount(firstNames[1], lastNames[1], correctReceiverPin);
        int incorrectSenderAccountNumber = 0;

        bank.deposit(senderAccountNumber, 150_000);
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
        assertEquals(0, bank.checkBalance(receiverAccountNumber, correctReceiverPin));

        assertThrowsExactly(IllegalArgumentException.class,
                ()-> bank.transfer(incorrectSenderAccountNumber, receiverAccountNumber, 50_000, correctSenderPin));
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
        assertEquals(0, bank.checkBalance(receiverAccountNumber, correctReceiverPin));
    }

    @Test
    public void testBank_transferRevertToOriginalStateWhenReceiversAccountNumberIsIncorrect(){
        String correctReceiverPin = pins[0];
        String correctSenderPin = pins[1];

        int senderAccountNumber =  bank.createAccount(firstNames[0], lastNames[0], correctSenderPin);
        int receiverAccountNumber =  bank.createAccount(firstNames[1], lastNames[1], correctReceiverPin);
        int incorrectReceiverAccountNumber = 0;

        bank.deposit(senderAccountNumber, 150_000);
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
        assertEquals(0, bank.checkBalance(receiverAccountNumber, correctReceiverPin));

        assertThrowsExactly(IllegalArgumentException.class,
                ()-> bank.transfer(senderAccountNumber, incorrectReceiverAccountNumber, 50_000, correctSenderPin));
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
        assertEquals(0, bank.checkBalance(receiverAccountNumber, correctReceiverPin));
    }

    @Test
    public void testBank_transferRevertToOriginalStateWhenSenderBalanceIsLessThanAmount(){
        String correctReceiverPin = pins[0];
        String correctSenderPin = pins[1];

        int senderAccountNumber =  bank.createAccount(firstNames[0], lastNames[0], correctSenderPin);
        int receiverAccountNumber =  bank.createAccount(firstNames[1], lastNames[1], correctReceiverPin);

        bank.deposit(senderAccountNumber, 150_000);
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
        assertEquals(0, bank.checkBalance(receiverAccountNumber, correctReceiverPin));

        assertThrowsExactly(IllegalArgumentException.class,
                ()-> bank.transfer(senderAccountNumber, receiverAccountNumber, 500_000, correctSenderPin));
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
        assertEquals(0, bank.checkBalance(receiverAccountNumber, correctReceiverPin));
    }

    @Test
    public void testBank_transferBetweenTheSameAccountThrowsException(){
        String correctSenderPin = pins[0];
        int senderAccountNumber = bank.createAccount(firstNames[0], lastNames[0], correctSenderPin);
        bank.deposit(senderAccountNumber, 150_000);
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));

        assertThrowsExactly(IllegalArgumentException.class,
                ()->bank.transfer(senderAccountNumber, senderAccountNumber, 50_000, correctSenderPin));
        assertEquals(150_000, bank.checkBalance(senderAccountNumber, correctSenderPin));
    }

    @Test
    public void testBank_canChangeAccountPIN(){
        String correctPIN = pins[0];
        String newPIN = pins[1];
        int accountNumber = bank.createAccount(firstNames[0], lastNames[0], correctPIN);
        bank.deposit(accountNumber, 75_000);

        assertEquals(75_000, bank.checkBalance(accountNumber, correctPIN));
        bank.resetPIN(accountNumber, correctPIN, newPIN);
        assertEquals(75_000, bank.checkBalance(accountNumber, newPIN));
    }

    @Test
    public void testBank_canChangeAccountFirstName(){
        String correctPIN = pins[0];
        String newFirstName = firstNames[1];
        int accountNumber = bank.createAccount(firstNames[0], lastNames[0], correctPIN);
        bank.updateFirstName(accountNumber, newFirstName, correctPIN);
        assertEquals(newFirstName, bank.getAccountFirstName(accountNumber));
    }

    @Test
    public void testBank_canChangeAccountLastName(){
        String correctPIN = pins[0];
        String newLastName = lastNames[1];
        int accountNumber = bank.createAccount(firstNames[0], lastNames[0], correctPIN);
        bank.updateLastName(accountNumber, newLastName, correctPIN);
        assertEquals(newLastName, bank.getAccountLastName(accountNumber));
    }

    @Test
    public void testBank_canGenerateAMiniStatement(){
//        test empty list is returned if no transaction happens
//        balance |   amount (green)| cash deposit
//        balance |    -amount (red)| cash withdrawal
//        balance |  +amount (green)| transfer in, from sender
//        balance |   -amount (red) | transfer out, to beneficiary

    }



}
