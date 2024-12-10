import java.util.ArrayList;
import java.util.Scanner;

public class BankeBankATM{
  static ArrayList<String[]> customersAccounts = new ArrayList<String[]>();
  static long accountNumberTemplate = 214_000_0000;
  
  public static boolean isExist(){ return true; }
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    String amount = "";
    
    String bankATMMenu = """
                  \033[1m\nBanke Bank ATM\033[0m
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
          System.out.print("Enter your first name: ");
          String firstName = input.nextLine();
          System.out.print("Enter your last name: ");
          String lastName = input.nextLine();
          System.out.print("Enter your four (4) digit pin XXXX: ");
          String pin = input.nextLine().replace(" ", "");
          String accountNumber = generateAccountNumber();
          if (openAccount(accountNumber, firstName, lastName, pin)){
            System.out.println("Account creation successful");
            System.out.printf("\033[1mYour new account number is: %s\033[0m%n", accountNumber);
          } else { System.out.println("Account creation failed, try again"); }
          break;
        case 2:
          System.out.println("\033[4mClose Your Account\033[0m");
          System.out.print("Enter the account number of the account you want to close: ");
          accountNumber = input.nextLine();
          System.out.print("Enter your PIN to grant authorisation: ");
          pin = input.nextLine();
          if (closeAccount(accountNumber, pin)){
            System.out.println("Account closing successful");
          } else { System.out.println("Account closing failed - make sure the account number and PIN is valid, then try again"); }
          break;
        case 3:
          System.out.println("\033[4mDeposit Money\033[0m");
          System.out.print("Enter the account number of the account you want to deposit into: ");
          accountNumber = input.nextLine();
          System.out.print("Enter the amount to deposit: ");
          amount = input.nextLine();
          
          if (creditAccount(accountNumber, addDecimalPointIfNeeded(amount))){
            System.out.println("Account deposit successful");
          } else { System.out.println("Account deposit failed - check the account number and try again"); }
          break;
        case 4:
          System.out.println("\033[4mWithdraw Money\033[0m");
          System.out.print("Enter the account number of the account you want to withdraw from: ");
          accountNumber = input.nextLine();
          System.out.print("Enter the amount to withdraw: ");
          amount = input.nextLine();
          System.out.print("Enter your PIN to grant authorisation: ");
          pin = input.nextLine();
          
          if (debitAccount(accountNumber, addDecimalPointIfNeeded(amount), pin)){
            System.out.println("Account withdrawal successful");
          } else { System.out.println("Account withdrawal failed - crosscheck the account number, pin and try again"); }
          break;
        case 5:
          System.out.println("\033[4mCheck Account Balance\033[0m");
          System.out.print("Enter the account number: ");
          accountNumber = input.nextLine();
          System.out.print("Enter your PIN to grant authorisation: ");
          pin = input.nextLine();
          String balance = checkAccountBalance(accountNumber, pin);
    
          if (!balance.equals("")){
            System.out.printf("Your account balance is: %s%n", balance);
          } else { System.out.println("Error: Please crosscheck the account number and try again"); }
          break;
        case 6:
          System.out.println("\033[4mTransfer Money\033[0m");
          System.out.print("Enter the your account number: ");
          String sourceAccountNumber = input.nextLine();
          String beneficiary = "";
          String destinationAccountNumber ="";
          
          while (beneficiary == "") {
            System.out.print("Enter the destination account number: ");
            destinationAccountNumber = input.nextLine();
            beneficiary = displayAccountNames(destinationAccountNumber);
            if(beneficiary == ""){ 
              System.out.println("Beneficiary not found, try again.");
            }
          }
          
          System.out.printf("You are about to send money to %s%n", beneficiary);
          System.out.print("Enter the amount: ");
          amount = input.nextLine();
          System.out.print("Enter your PIN to authorise transfer: ");
          pin = input.nextLine();
          
          if (transferMoney(sourceAccountNumber, destinationAccountNumber, addDecimalPointIfNeeded(amount), pin)){
            System.out.println("Account transfer successful");
          } else { System.out.println("Account transfer failed - crosscheck the account number, pin and try again"); }
          break;
        case 7:
          System.out.println("\033[4mChange Transaction PIN\033[0m");
          System.out.print("Enter your account number: ");
          accountNumber = input.nextLine();
          System.out.print("Enter your current PIN: ");
          String oldPin = input.nextLine();
          System.out.print("Enter your new PIN: ");
          String newPin = input.nextLine();
          
          if (changeAccountPIN(accountNumber, oldPin, newPin)){
            System.out.println("PIN change successful");
          } else { System.out.println("PIN change failed - crosscheck the account number, pin and try again"); }
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
 
  public static boolean openAccount(String accountNumber, String firstName, String lastName, String pin){
    String zeroBalance = "0.00";
    if(getAccountId(accountNumber) == -1){
      String[] newAccount = {accountNumber, firstName, lastName, zeroBalance, pin};
      return customersAccounts.add(newAccount);
    }else return false;
  }
  public static String generateAccountNumber(){
    return "" + accountNumberTemplate--;
  }
  
  public static int getAccountId(String accountNumber){
    int accountNumberColumn = 0;
    for(int index = 0; index < customersAccounts.size(); index += 1){
      if (accountNumber.equalsIgnoreCase(customersAccounts.get(index)[accountNumberColumn])){
        return index;
      }
    }
    return -1;
  }
  
  public static boolean closeAccount(String accountNumber, String pin){
    int accountId = getAccountId(accountNumber);
    int accountPinColumn = 4;
    if (accountId == -1){
      return false;
    }
    if (customersAccounts.get(accountId)[accountPinColumn].equalsIgnoreCase(pin)){
      if (customersAccounts.remove(accountId) == null){ return false; }
      else { return true; }
    }else{
      return false;
    }
  }
  
  public static String addDecimalPointIfNeeded(String amount){
    if (amount.contains(".")){ return amount; }
    else{
      return amount + ".00";
    }
  }
  
  public static boolean creditAccount(String accountNumber, String amount){
    int accountId = getAccountId(accountNumber);
    if (accountId == -1 || amount.substring(0,1) == "-"){
      return false;
    }
    
    int accountBalanceColumn = 3;
    String currentBalance = customersAccounts.get(accountId)[accountBalanceColumn];
    String newBalance = addMoneteryStringValue(currentBalance, amount);
    customersAccounts.get(accountId)[accountBalanceColumn] = newBalance;
    return true;
  }
  
  public static String addMoneteryStringValue(String amount1, String amount2){
    long amount1Whole = Long.valueOf(amount1.split("\\.")[0]);
    int amount1Fraction = Integer.valueOf(amount1.split("\\.")[1]);
    long amount2Whole = Long.valueOf(amount2.split("\\.")[0]);
    int amount2Fraction = Integer.valueOf(amount2.split("\\.")[1]);
    
    long sumOfWholes = amount1Whole + amount2Whole;
    int sumOfFractions = amount1Fraction + amount2Fraction;
    sumOfWholes += sumOfFractions / 100;
    sumOfFractions = sumOfFractions % 100;
    String result = sumOfWholes + "." + sumOfFractions;
    return result;
  }
  
  public static boolean debitAccount(String accountNumber, String amount, String pin){
    int accountId = getAccountId(accountNumber);
    int accountPinColumn = 4;
    if (accountId == -1){
      return false;
    }
    if (customersAccounts.get(accountId)[accountPinColumn].equalsIgnoreCase(pin)){
      int accountBalanceColumn = 3;
      String currentBalance = customersAccounts.get(accountId)[accountBalanceColumn];
      String newBalance = substractMoneteryStringValue(currentBalance, amount);
      customersAccounts.get(accountId)[accountBalanceColumn] = newBalance;
      return true;
    }else{
      return false;
    }    
  }
  
  public static String substractMoneteryStringValue(String amount1, String amount2){
    long amount1Whole = Long.valueOf(amount1.split("\\.")[0]);
    int amount1Fraction = Integer.valueOf(amount1.split("\\.")[1]);
    long amount2Whole = Long.valueOf(amount2.split("\\.")[0]);
    int amount2Fraction = Integer.valueOf(amount2.split("\\.")[1]);
    int diffOfFractions;
    long diffOfWholes;
    
    if (Float.valueOf(amount1Whole + "." + amount1Fraction) < Float.valueOf(amount2Whole + "." + amount2Fraction)){
      return ("-" + substractMoneteryStringValue(amount2, amount1));
    }
    
    diffOfWholes = amount1Whole - amount2Whole;
    if (amount1Fraction >= amount2Fraction){
      diffOfFractions = amount1Fraction - amount2Fraction;
    } else {
      diffOfWholes -= 1;
      amount1Fraction += 100;
      diffOfFractions = amount1Fraction - amount2Fraction;
    }
    String result = diffOfWholes + "." + diffOfFractions;
    return result;
  }
  
  
  public static String checkAccountBalance(String accountNumber, String pin){
    int accountId = getAccountId(accountNumber);
    int accountBalanceColumn = 3;
    int accountPinColumn = 4;
    
    if(accountId == -1){ return ""; }
    if (customersAccounts.get(accountId)[accountPinColumn].equalsIgnoreCase(pin)){
      return customersAccounts.get(accountId)[accountBalanceColumn];
    }else{
      return "";
    }
  }
  
  public static String displayAccountNames(String accountNumber){
    int accountId = getAccountId(accountNumber);
    if (accountId != -1){
      return customersAccounts.get(accountId)[1] + " " + customersAccounts.get(accountId)[2];
    } else {
      return "";
    }
  }
  
  public static boolean transferMoney(String sourceAccountNumber, String destinationAccountNumber, String amount, String pin){
    int sourceAccountId = getAccountId(sourceAccountNumber);
    int destinationAccountId = getAccountId(destinationAccountNumber);
    
    if (debitAccount(sourceAccountNumber, amount, pin)){
      return creditAccount(destinationAccountNumber, amount);
    }
    return false;    
  }
  
  
  public static boolean changeAccountPIN(String accountNumber, String oldPin, String newPin){
    int accountId = getAccountId(accountNumber);
    int accountPinColumn = 4;
    
    if(customersAccounts.get(accountId)[accountPinColumn].equalsIgnoreCase(oldPin)){
      customersAccounts.get(accountId)[accountPinColumn] = newPin;
      return true;
    }
    return false;    
  }

}
