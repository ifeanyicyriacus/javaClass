import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class CheckOutApp{ 
    public static void main(String[] args){
    final double VAT = 0.075;
    Scanner input = new Scanner(System.in);
    ArrayList<String> productNameList = new ArrayList<String>();
    ArrayList<Double[]> productQtyPriceAndTotalList = new ArrayList<Double[]>();
    
    String clientHeader = """
    \033[1m
    SEMICOLON STORES
    (HEAD OFFICE)
    LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
    TEL: 03293828343
    \033[0m""";
    
    System.out.println(clientHeader);
    System.out.println("What is the customer name? ");
    String customerName = input.nextLine();
    addpurchasesTolist(input, productNameList, productQtyPriceAndTotalList);
    
    System.out.println("Enter you name to sign off: ");
    String cashierName = input.nextLine();
    System.out.println("Enter discount amount: ");
    double discountRate = input.nextDouble() / 100;
    
    double subTotal = calculateSubTotal(productQtyPriceAndTotalList);
    double discount = subTotal * discountRate;
    double vatApplied = subTotal * VAT;
    double billTotal = subTotal - discount + vatApplied;
    
    System.out.print(displayInvoice(clientHeader, cashierName, customerName, productNameList, productQtyPriceAndTotalList, subTotal, discount, vatApplied, billTotal));
    System.out.println("=".repeat(50));
    System.out.printf("THIS IS NOT A RECEIPT KINDLY PAY %12.2f%n", billTotal);
    System.out.println("=".repeat(50));
    System.out.println("How much did the customer give you?");
    double payment = input.nextDouble();
    
    System.out.println(displayInvoice(clientHeader, cashierName, customerName, productNameList, productQtyPriceAndTotalList, subTotal, discount, vatApplied, billTotal));
    System.out.print(displayPaymentSummary(billTotal, payment));
    System.out.println("=".repeat(50));
    System.out.println("\t\tTHANK YOU FOR YOUR PATRONAGE");
    System.out.println("=".repeat(50));
  }
  
    private static void addpurchasesTolist(Scanner input, ArrayList<String> productNameList, ArrayList<Double[]> productQtyPriceAndTotalList){
    boolean isShopping = true; double unitsPurchased; double pricePerUnit;
    
    do{
      System.out.print("Enter product purchased: ");
      productNameList.add(input.next());
      System.out.print("Enter number of unit purchased: ");
      unitsPurchased = input.nextDouble();
      System.out.print("Enter price per unit: NGN ");
      pricePerUnit = input.nextDouble();
      
      productQtyPriceAndTotalList.add(new Double[] {unitsPurchased, pricePerUnit, (unitsPurchased * pricePerUnit)});
      
      System.out.print("Want to add more Items (yes/no)? ");
      isShopping = input.next().toLowerCase().equals("yes");
    }while(isShopping);
    
  }
  
  public static String displayInvoice(String message, String cashierName, String customerName, ArrayList<String> productNameList, ArrayList<Double[]> productQtyPriceAndTotalList, double subTotal, double discount, double vatApplied, double billTotal){
    String dashesEqual = "=".repeat(50) +"\n";
    String dashesMinus = "-".repeat(50) +"\n";
    
    message += String.format("Date = %s%n", new Date());
    message += String.format("Cashier: %s%n", cashierName);
    message += String.format("Customer name: %s%n", customerName);
    message += dashesEqual;
    message += String.format("%15s\t%5s\t%7s\t%13s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
    message += dashesMinus;
    message += displayItems(productNameList, productQtyPriceAndTotalList);
    message += dashesMinus;
      
    message += String.format("\t\t%15s\t%13.2f%n", "Sub Total:", subTotal);
    message += String.format("\t\t%15s\t%13.2f%n", "Discount:", discount);
    message += String.format("\t\t%15s\t%13.2f%n", "VAT @ 7.5%:", vatApplied);
    message += dashesEqual;
    message += String.format("\t\t%15s\t%13.2f%n", "Bill Total:", billTotal);
    return message;
  }
  
  private static String displayItems(ArrayList<String> productNameList, ArrayList<Double[]> productQtyPriceAndTotalList){
    String items = "";
    for(int index = 0; index < productNameList.size(); index += 1){
      String name = productNameList.get(index);
      double qty = productQtyPriceAndTotalList.get(index)[0];
      double price = productQtyPriceAndTotalList.get(index)[1];
      double total = productQtyPriceAndTotalList.get(index)[2];
      items += String.format("%15s\t%5.1f\t%7.2f\t%13.2f%n", name, qty, price, total);
    }
    return items + "\n";
  }
  
  private static double calculateSubTotal(ArrayList<Double[]> productQtyPriceAndTotalList){
    double subTotal = 0;
    for (Double[] item: productQtyPriceAndTotalList){
      subTotal += (double)item[2];
    }
    return subTotal;
  }
  
  private static String displayPaymentSummary(double billTotal, double payment){
    String message = "";
    message += String.format("\t\t%15s\t%13.2f%n", "Amount Paid:", payment);
    message += String.format("\t\t%15s\t%13.2f%n", "Balance:", (payment - billTotal));
    return message;
  }
  
}


