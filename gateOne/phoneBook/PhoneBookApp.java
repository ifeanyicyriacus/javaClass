import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookApp{
  static Scanner input = new Scanner(System.in);
  
  public static void main(String[] args){
    ArrayList<String[]> contactList = new ArrayList<String[]>();
    String phoneBookMenu = """
                  \033[1mPhone Book\033[0m
    Menu: 
    1. Add contact
    2. Edit contact
    3. Remove contact
    4. Find contact by phone number
    5. Find contact by first name
    6. Find contact by last name
    7. View all contact
    0. Exit
    
    >>>>""";
    
    boolean isActive = true;
    while(isActive){
      System.out.print(phoneBookMenu);
      int choice = input.nextInt();
      input.nextLine();
      String key;
      int columnNumber;
      int contactIndex;
      switch(choice){
        case 1:
          System.out.println("\033[4mCreate New Contact\033[0m");
          String[] newContact = collectNewContactInfo();
          System.out.println((addContact(contactList, newContact))?"\033[32mOperation successful\033[0m":"\033[31mOperation unsuccessful\033[0m");
          break;
        case 2:
          System.out.println("\033[4mEdit Contact\033[0m");
          System.out.print("Enter the serial number of the contact to edit: ");
          contactIndex = input.nextInt(); input.nextLine();
          boolean isEdited = editContact(contactList, --contactIndex);
          System.out.println((isEdited)?"\033[32mContact edit: successful\033[0m":String.format("\033[31mUnsuccessful: No contact exist at index (%d) in contact list\033[0m", ++contactIndex));
          break;
        case 3:
          System.out.println("\033[4mRemove Contact\033[0m");
          System.out.print("Enter the serial number of the contact to remove: ");
          contactIndex = input.nextInt(); input.nextLine();
          boolean isRemoved = removeContact(contactList, --contactIndex);
          System.out.println((isRemoved)?"\033[32mContact removal: successful\033[0m":String.format("\033[31mUnsuccessful: No contact exist at index (%d) in contact list\033[0m", ++contactIndex));
          break;
        case 4:
          System.out.println("\033[4mFind Contact By Phone Number\033[0m");
          System.out.print("Enter the phone number: ");
          key = input.nextLine();
          columnNumber = 2;
          displayContact(findContactBy(contactList, columnNumber, key));
          break;
        case 5:
          System.out.println("\033[4mFind Contact By First Name\033[0m");
          System.out.print("Enter the first name: ");
          key = input.nextLine();
          columnNumber = 0;
          displayContact(findContactBy(contactList, columnNumber, key));
          break;
        case 6:
          System.out.println("\033[4mFind Contact By Last Name\033[0m");
          System.out.print("Enter the last name: ");
          key = input.nextLine();
          columnNumber = 1;
          displayContact(findContactBy(contactList, columnNumber, key));
          break;
        case 7:
          System.out.println("\033[4mAll Contacts\033[0m");
          displayAllContact(contactList);
          break;
        case 0:
          System.out.println("\033[1m-----------Exited Phonebook Successfully-----------\033[0m");
          isActive = false;
          break;
        default:
          System.out.println("\033[1m-----------Invalid input: Try again-----------\033[0m");
      }
    }
  }
  
  public static String[] collectNewContactInfo(){
    System.out.print("Enter your first name: ");
    String firstName = input.nextLine();
    System.out.print("Enter your last name: ");
    String lastName = input.nextLine();
    System.out.print("Enter your phone number: ");
    String phoneNumber = input.nextLine().replace(" ", "");
    System.out.print("Enter your home address: ");
    String homeAddress = input.nextLine();
    System.out.print("Enter your e-mail address: ");
    String emailAdress = input.nextLine();
  
    String[] newContact = {firstName, lastName, phoneNumber, homeAddress, emailAdress};
    return newContact;
  }
  
  public static boolean addContact(ArrayList<String[]> contactList, String[] newContact){
    return contactList.add(newContact);
  }

  public static boolean editContact(ArrayList<String[]> contactList, int contactIndex){
	  if(contactIndex < 0 || contactIndex >= contactList.size()){
      return false;
	  }else {
      int firstNameIndex = 0; int lastNameIndex = 1; int phoneNumberIndex = 2;
      int homeAddressIndex = 3; int emailAdressIndex = 4;
      
      String[] contact = contactList.get(contactIndex);
      System.out.printf("Enter new first name to replace (%s): ", contact[firstNameIndex]);
      contactList.get(contactIndex)[firstNameIndex] = input.nextLine();
      System.out.printf("Enter new last name to replace (%s): ", contact[lastNameIndex]);
      contactList.get(contactIndex)[lastNameIndex] = input.nextLine();
      System.out.printf("Enter new phone number name to replace (%s): ", contact[phoneNumberIndex]);
      contactList.get(contactIndex)[phoneNumberIndex] = input.nextLine().replace(" ", "");
      System.out.printf("Enter new home address to replace (%s): ", contact[homeAddressIndex]);
      contactList.get(contactIndex)[homeAddressIndex] = input.nextLine();
      System.out.printf("Enter new email address to replace (%s): ", contact[emailAdressIndex]);
      contactList.get(contactIndex)[emailAdressIndex] = input.nextLine();
      return true;
    }
	}
	
  public static boolean removeContact(ArrayList<String[]> contactList, int contactIndex){
	  if(contactIndex < 0 || contactIndex >= contactList.size()){
      return false;
	  }else {
	    int sizeBeforeRemove = contactList.size();
	    contactList.remove(contactIndex);
		  return (sizeBeforeRemove + 1) == contactList.size();
	  }
	}
  
  public static int getIndexOfElement(ArrayList<String[]> contactList, int columnNumber, String keyword){
    for (int index = 0; index < contactList.size(); index += 1){
		  if (contactList.get(index)[columnNumber].toLowerCase().contains(keyword.toLowerCase())){
			  return index;
		  }
    }
	  return -1;
	}
	
	public static String[] findContactBy(ArrayList<String[]> contactList, int columnNumber, String key){
  	int searchResultIndex = getIndexOfElement(contactList, columnNumber, key);
  	if(searchResultIndex != -1){
		  return contactList.get(searchResultIndex);
	  }else{
	    return new String[0];
	  }
	}
	
	public static void displayContact(String[] contact){
	  if(contact.length != 0){
      String firstName = contact[0];
      String lastName = contact[1];
      String phoneNumber = contact[2];
      String homeAddress = contact[3];
      String emailAdress = contact[4];
      
      String output = String.format("\033[1mName:\033[0m %s %s%n", firstName, lastName);
      output += String.format("\033[1mTelephone:\033[0m %s%n", phoneNumber);
      output += String.format("\033[1mE-mail:\033[0m %s%n", emailAdress);
      output += String.format("\033[1mHome address:\033[0m %s%n", homeAddress);
	    System.out.print(output);
	  }else{
	    System.out.print("\033[1m--------------Contact not found----------------\033[0m");
	  }
	}
	
  public static void displayAllContact(ArrayList<String[]> contactList){
    if (contactList.size() > 0){
      for(int index = 0; index < contactList.size(); index += 1){
        System.out.printf("\033[1m[%d]\033[0m%n", (index + 1));
        displayContact(contactList.get(index));
        System.out.println("\033[1m-----------------------------------\033[0m");
      }
    }else{
      	System.out.println("\033[1m--------------Phone book is empty----------------\033[0m");
    }
  }

}
