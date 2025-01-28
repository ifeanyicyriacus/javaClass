package okolibank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBank {
    Bank bank;
    Account newBankAccount;

    String firstName;
    String lastName;
    String pin;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        String firstName = "John";
        String lastName = "Doe";
        String pin = "1234";
        newBankAccount = bank.createAccount(firstName, lastName, pin);
    }

    @Test
    public void testBank_exist() {
        assertTrue(bank.exist());
    }

    @Test
    public void testBank_canCreateAccount() {
        assertEquals(0, Bank.getNumberOfAccounts());
        Account newAccount = bank.createAccount(firstName, lastName, pin);
        assertNotNull(newAccount);
        assertEquals(firstName, newAccount.getFirstName());
        assertEquals(lastName, newAccount.getLastName());
        assertEquals(1, Bank.getNumberOfAccounts());
    }

    @Test
    public void testBank_canAcceptAccountDeposit() {
        assertEquals(0, newBankAccount.checkBalance(pin));
        newBankAccount.deposit(10_000);
        assertEquals(10_000, newBankAccount.checkBalance(pin));
    }

    @Test
    public void testBank_canAcceptAccountWithdrawWhenBalanceIsLessThanAmount() {
        assertEquals(0, newBankAccount.checkBalance(pin));
        newBankAccount.deposit(10_000);
        newBankAccount.withdraw(9_000, pin);
        assertEquals(1_000, newBankAccount.checkBalance(pin));
    }

    @Test
    public void testBank_canAcceptAccountWithdrawWhenBalanceIsGreaterThanAmount() {

    }

}
