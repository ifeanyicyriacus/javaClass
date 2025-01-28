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
        bank = new Bank();
    }

    @Test
    public void testBank_exist() {
        assertTrue(bank.exist());
    }

    @Test
    public void testBank_canCreateAccount() {
        int numberOfAccountsInBank = bank.getNumberOfAccounts();
        Account newBankAccount = bank.createAccount(firstNames[0], lastNames[0], pins[0]);
        assertNotNull(newBankAccount);
        assertEquals(firstNames[0], newBankAccount.getFirstName());
        assertEquals(lastNames[0], newBankAccount.getLastName());
        assertEquals(0, newBankAccount.checkBalance("1234"));
        assertEquals(numberOfAccountsInBank + 1, bank.getNumberOfAccounts());
    }

    @Test
    public void testBank_canDepositIntoAnAccount() {
        Account newBankAccount = bank.createAccount(firstNames[0], lastNames[0], pins[0]);
        int accountNumber1 = newBankAccount.getAccountNumber();
        bank.deposit(accountNumber1, 100_000);
        assertEquals(100_000, bank.checkBalance(accountNumber1, pins[0]));

        Account anotherBankAccount = bank.createAccount(firstNames[1], lastNames[1], pins[1]);
        int accountNumber2 = anotherBankAccount.getAccountNumber();
        bank.deposit(accountNumber2, 150_000);
        assertEquals(150_000, bank.checkBalance(accountNumber2, pins[1]));
    }

    @Test
    public void testBank_canAcceptWithdrawWhenBalanceIsMoreThanAmount() {
        String pin = pins[0];
        Account newBankAccount = bank.createAccount(firstNames[0], lastNames[0], pin);
        int accountNumber = newBankAccount.getAccountNumber();
        assertEquals(0, newBankAccount.checkBalance(pin));
        bank.deposit(accountNumber,10_000);
        bank.withdraw(accountNumber, 9_000, pin);
        assertEquals(1_000, newBankAccount.checkBalance(pin));
    }

    @Test
    public void testBank_canEnableMoneyTransfer() {
        String pin1 = pins[0];
        String pin2 = pins[1];
        Account newBankAccount = bank.createAccount(firstNames[0], lastNames[0], pin1);
        Account anotherBankAccount = bank.createAccount(firstNames[1], lastNames[1], pin2);
        int accountNumber1 = newBankAccount.getAccountNumber();
        int accountNumber2 = anotherBankAccount.getAccountNumber();

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

}
