package okolibank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccount {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(100, "Ifeanyi", "Cyriacus", "0000");
    }

    @Test
    public void testAccount_exist(){
        assertTrue(account.exist());
    }

    @Test
    public void testAccount_canBeCreated(){
        assertNotNull(account);
        assertEquals(100, account.getAccountNumber());
        assertEquals("Ifeanyi", account.getFirstName());
        assertEquals("Cyriacus", account.getLastName());
    }
    
    @Test
    public void testAccount_canBeUpdated(){
        account.updateFirstName("Valentine");
        assertEquals("Valentine", account.getFirstName());
        account.updateLastName("Mark");
        assertEquals("Mark", account.getLastName());
    }

    @Test
    public void testAccount_balanceIsSetToZeroAtCreation(){
        assertEquals(0, account.checkBalance("0000"));
    }

    @Test
    public void testAccount_pinCanOnlyBeUpdatedWhenTheOldPinIsCorrect(){
        assertThrows(IllegalArgumentException.class,
                () -> account.updatePin("0110", "1234"));
    }

    @Test
    public void testAccount_pinUpdateWorks(){
        assertEquals(0, account.checkBalance("0000"));
        account.updatePin("0000", "1234");
        assertEquals(0, account.checkBalance("1234"));
    }

    @Test
    public void testAccount_canOnlyCheckBalanceWhenPinIsCorrect(){
        assertThrows(IllegalArgumentException.class,
                () -> account.checkBalance("0110"));
        assertEquals(0, account.checkBalance("0000"));
    }

    @Test
    public void testAccount_supportsDeposit(){
        account.deposit(30_000);
        assertEquals(30_000, account.checkBalance("0000"));
        account.deposit(300);
        account.deposit(400);
        assertEquals(30_700, account.checkBalance("0000"));
    }

    @Test
    public void testAccount_throwExceptionForInvalidDepositAmount(){
        assertThrows(IllegalArgumentException.class, ()-> account.deposit(-300));
        assertEquals(0, account.checkBalance("0000"));
    }

    @Test
    public void testAccount_supportsWithdrawal(){
        account.deposit(30_000);
        account.withdraw(10_000, "0000");
        assertEquals(20_000, account.checkBalance("0000"));
    }

    @Test
    public void testAccount_throwExceptionForInvalidWithdrawAmount(){
        account.deposit(30_000);
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(-200, "0000"));
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(40_000, "0000"));
    }

    @Test
    public void testAccount_throwExceptionForIncorrectPin(){
        account.deposit(30_000);
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(300, "0400"));
    }
}
