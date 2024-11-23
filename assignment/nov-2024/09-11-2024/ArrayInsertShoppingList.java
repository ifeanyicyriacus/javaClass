import java.util.Scanner;
public class ArrayInsertShoppingList{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String[] shoppingList = {"1. Rice", "2. Beans", "3. Tomato", "4. Milk", "5. Bread", "6. Oil and Butter", "7. Vegetable" };
		


		System.out.println("\033[1mRecommended shopping list: \033[0m");
		for(int index = 0; index < shoppingList.length; index += 1){
			System.out.println(shoppingList[index]);
		}
		System.out.print("\033[3mEnter the number of the item you wish to replace: \033[0m");
		int selection = input.nextInt();
		System.out.printf("Enter the item you want to replace [%s] for: ", shoppingList[selection - 1] );
    
    String newItem = input.next();
		shoppingList[selection - 1] = selection +". "+ newItem;
		System.out.println("\033[1m\nYour Shopping list: \033[0m");
		for(int index = 0; index < shoppingList.length; index += 1){
			System.out.println(shoppingList[index]);
		}
		System.out.println("\033[3mLet's head out :) \033[0m");
		
	}
}
