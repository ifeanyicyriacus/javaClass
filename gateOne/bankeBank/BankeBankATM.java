import java.util.ArrayList;
import java.util.Scanner;

public class BankeBankATM{
  static Scanner input = new Scanner(System.in);
  static ArrayList<String[]> customersAccounts = new ArrayList<String[]>();
    
  public static void main(String[] args){
    
    String bankATMMenu = """
                  \033[1mBanke Bank ATM\033[0m
    Menu: 
    1. Create Account
    2. Close Account
    3. Deposit money
    4. Withdraw Money
    5. Check Account Balance
    6. Transfer
    7. Change PIN
    0. Exit
    
    >>>>""";
    
    boolean isActive = true;
    while (isActive){
      System.out.print(bankATMMenu);
      int choice = input.nextInt(); input.nextLine();
      switch(choice){
        case 1:
          System.out.println("\033[4mOpen An Account\033[0m");
          openAccount();
          break;
        case 2:
          System.out.println("\033[4mClose Your Account\033[0m");
          closeAccount(customersAccounts, accountNumber);
          break;
        case 3:
          System.out.println("\033[4mDeposit Money\033[0m");
          accountDeposit(customersAccounts, accountNumber, amount);
          break;
        case 4:
          System.out.println("\033[4mWithdraw Money\033[0m");
          accountWithdrawal(customersAccounts, accountNumber, amount);
          break;
        case 5:
          System.out.println("\033[4mCheck Account Balance\033[0m");
          checkAccountBalance(customersAccounts, accountNumber);
          break;
        case 6;
          System.out.println("\033[4mTransfer Money\033[0m");
          transferMoney(customersAccounts, sourceAccountNumber, destinationAccountNumber, amount);
          break;
        case 7:
          System.out.println("\033[4mChange Transaction PIN\033[0m");
          changeAccountPIN();
          break;
        case 0:
          System.out.println("\033[1m-----------ATM Shutdown Successful-----------\033[0m");
          isActive = false;
          break;
        default:
          System.out.println("\033[1m-----------Invalid input: Try again-----------\033[0m");
      }
    }
  }
 
  //display account information, account number, name, balance,
  public static boolean openAccount(String accountNumber, String firstName, String lastName, String pin){
    String zeroBalance = "0.00";
    if(getAccountId(accountNumber) == -1){
      String[] newAccount = {accountNumber, firstName, lastName, zeroBalance, pin};
      return this.customersAccounts.add(newAccount);
    }else return false;
  }
  
  private static int getAccountId(String accountNumber){
    int accountNumberColumn = 0;
    for(int index = 0; index < customerAccounts.size(); index += 1){
      if (accountNumber.equalsIgnoreCase(customerAccounts.get(index)[accountNumberColumn])){
        return index;
      }
    }
    return -1;
  }
  
  public static boolean closeAccount(String accountNumber){
    int accountId = getAccountId(accountNumber);
    if(accountId == -1){
      return false;
    }else{
      return this.customersAccounts.remove(accountId);
    }
  }
  
  public static boolean accountDeposit(accountNumber, String amount){
    int accountId = getAccountId(accountNumber);
    int accountBalanceColumn = 3;
    String currentBalance = accountNumber.get(accountId)[accountBalanceColumn];
    String newBalance = addMoneteryStringValue(currentBalance + amount);
    
  }
  
  private static String addMoneteryStringValue(String amount1, amount2){
  
  }
  
  accountWithdrawal(customersAccounts, accountNumber, amount, pin);
  checkAccountBalance(customersAccounts, accountNumber);
  transferMoney(customersAccounts, sourceAccountNumber, destinationAccountNumber, amount, pin);
  changeAccountPIN(); 










}
