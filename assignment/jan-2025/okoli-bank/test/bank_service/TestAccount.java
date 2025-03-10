package bank_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccount {
    private Account account;
    private final String correctPIN = "0000";
    private final String wrongPIN = "1111";
    private final String emptyPIN = "";

    @BeforeEach
    void setUp() {
        account = new Account(100, "Ifeanyi", "Cyriacus", correctPIN);
    }

    @Test
    public void testAccount_canBeCreated(){
        assertNotNull(account);
        assertEquals(100, account.getAccountNumber());
        assertEquals("Ifeanyi", account.getFirstName());
        assertEquals("Cyriacus", account.getLastName());
    }

    @Test
    public void testAccount_canBeCreatedOnlyWithLegalValues(){
        assertThrowsExactly(IllegalArgumentException.class,
                ()-> new Account(0, "Ifeanyi", "Cyriacus", correctPIN));
        assertThrowsExactly(IllegalArgumentException.class,
                ()-> new Account(100, "", "Cyriacus", correctPIN));
        assertThrowsExactly(IllegalArgumentException.class,
                ()-> new Account(100, "Ifeanyi", "", correctPIN));
        assertThrowsExactly(IllegalArgumentException.class,
                ()-> new Account(100, "Ifeanyi", "Cyriacus", emptyPIN));
    }
    
    @Test
    public void testAccount_profileDetailCanBeUpdated(){
        account.updateFirstName("Valentine", correctPIN);
        assertEquals("Valentine", account.getFirstName());
        account.updateLastName("Mark", correctPIN);
        assertEquals("Mark", account.getLastName());
    }

    @Test
    public void testAccount_exceptionOccurWhenManipulatingProfileDetailUsingIncorrectPIN(){
        assertEquals("Ifeanyi", account.getFirstName());
        assertEquals("Cyriacus", account.getLastName());

        assertThrows(IllegalArgumentException.class,
                ()-> account.updateFirstName("Valentine", wrongPIN));
        assertEquals("Ifeanyi", account.getFirstName());
        assertThrows(IllegalArgumentException.class,
                ()-> account.updateLastName("Mark", wrongPIN));
        assertEquals("Cyriacus", account.getLastName());
    }

    @Test
    public void testAccount_balanceIsSetToZeroAtCreation(){
        assertEquals(0, account.checkBalance(correctPIN));
    }

    @Test
    public void testAccount_pinCanOnlyBeUpdatedWhenTheOldPinIsCorrect(){
        assertThrows(IllegalArgumentException.class,
                () -> account.updatePin(wrongPIN, "1234"));
    }

    @Test
    public void testAccount_pinUpdateWorks(){
        String newPin = "1234";
        assertEquals(0, account.checkBalance(correctPIN));
        account.updatePin(correctPIN, newPin);
        assertEquals(0, account.checkBalance(newPin));
    }

    @Test
    public void testAccount_canOnlyCheckBalanceWhenPinIsCorrect(){
        assertThrows(IllegalArgumentException.class,
                () -> account.checkBalance(wrongPIN));
        assertEquals(0, account.checkBalance(correctPIN));
    }

    @Test
    public void testAccount_supportsBalanceIncrease(){
        account.increaseBy(30_000);
        assertEquals(30_000, account.checkBalance(correctPIN));
        account.increaseBy(300);
        account.increaseBy(400);
        assertEquals(30_700, account.checkBalance(correctPIN));
    }

    @Test
    public void testAccount_throwExceptionForInvalidIncreaseAmount(){
        assertThrows(IllegalArgumentException.class, ()-> account.increaseBy(-300));
        assertEquals(0, account.checkBalance(correctPIN));
    }

    @Test
    public void testAccount_supportsWithdrawal(){
        account.increaseBy(30_000);
        account.withdraw(10_000, correctPIN);
        assertEquals(20_000, account.checkBalance(correctPIN));
    }

    @Test
    public void testAccount_throwExceptionForInvalidWithdrawAmount(){
        account.increaseBy(30_000);
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(-200, correctPIN));
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(40_000, correctPIN));
    }

    @Test
    public void testAccount_throwExceptionWhenWithdrawingUsingIncorrectPin(){
        account.increaseBy(30_000);
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(300, wrongPIN));
    }
}
