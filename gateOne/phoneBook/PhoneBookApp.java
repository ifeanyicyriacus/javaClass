public class PhoneBookApp{
  static Scanner input = new Scanner(System.in);
  
  public static void main(String[] args){
    //int numberOfContactField = 5;
    //ArrayList<String[]> contactList = new ArrayList<String[numberOfContactField]>();
    ArrayList<String[]> contactList = new ArrayList<String[]>();
    String phoneBookMenu = """
    Menu: 
    1. Add contact
    2. Edit contact
    3. Remove contact
    4. Find contact by phone number
    5. Find contact by first name
    6. Find contact by last name
    0. Exit
    >>>>_""";
    
    boolean isActive = true;
    while(isActive){
      System.out.print(phoneBookMenu);
      int choice = input.nextInt();
      input.nextLine();
      int key;
      int columnNumber;
      switch(choice){
        case 1:
          System.out.println("\033[4mCreate New Contact\033[0m");
          String[] newContact = collectNewContactInfo();
          System.out.print((addContact(contactList, newContact))?"Operation successful":"Operation unsuccessful");
          break;
        case 2:
          System.out.println("\033[4mEdit Contact\033[0m");
          break;
        case 3:
          System.out.println("\033[4mRemove Contact\033[0m");
          break;
        case 4:
          System.out.println("\033[4mFind Contact By Phone Number\033[0m");
          System.out.print("Enter the phone number: ");
          key = input.next();
          columnNumber = 2;
          displayContact(findContactBy(contactList, columnNumber, key));
          break;
        case 5:
          System.out.println("\033[4mFind Contact By First Name\033[0m");
          System.out.print("Enter the first name: ");
          key = input.next();
          columnNumber = 0;
          displayContact(findContactBy(contactList, columnNumber, key));
          break;
        case 6:
          System.out.println("\033[4mFind Contact By Last Name\033[0m");
          System.out.print("Enter the last name: ");
          key = input.next();
          columnNumber = 1;
          displayContact(findContactBy(contactList, columnNumber, key));
          break;
        case 0:
          System.out.println("-----------Exited Phonebook Successfully-----------");
          isActive = false;
          break;
        default:
          System.out.println("-----------Invalid input: Try again-----------");
      }
    }
  }
  
  public static String[] collectNewContactInfo(){
    System.out.print("Enter your first name: ");
    String firstName = input.next();
    System.out.print("Enter your last name: ");
    String lastName = input.next();
    System.out.print("Enter your phone number: ");
    String phoneNumber = input.nextln().replace(" ", "");
    System.out.print("Enter your home address: ");
    String homeAddress = input.nextLine();
    System.out.print("Enter your e-mail address: ");
    String emailAdress = input.next();
  
    String[] newContact = {firstName, lastName, phoneNumber, homeAddress, emailAdress};
    return newContact;
  }
  
  public static bool addContact(ArrayList<String[]> contactList, String[] newContact){
    return contactList.add(newContact);
  }
  
  public static int getIndexOfElement(ArrayList<String[]> contactList, int columnNumber, String keyword){
    for (int index = 0; index < contactList.size(); index += 1){
		  if (contactList.get(index)[columnNumber].toLowerCase().contains(keyword.toLowerCase())){
			  return index;
		  }
    }
	  return -1;
	}
	
	public static String[] findContactBy(ArrayList<String[]> contactList, int columnNumber; String key){
  	int searchResultIndex = getIndexOfElement(contactList, columnNumber, key);
  	if(searchResultIndex != -1){
		  return contactList.get(searchResultIndex);
	  }else{
	    return new String[0];
	  }
	}
	
	public static displayContact(String[] contact){
    String firstName = contact[0];
    String lastName = contact[1];
    String phoneNumber = contact[2];
    String homeAddress = contact[3];
    String emailAdress = contact[4];
    
	  if(contact.length != 0){
      String output = String.format("Name: %s %s%n", firstName, lastName)
      output += String.format("Telephone: %s%n", phoneNumber);
      output += String.format("E-mail: %s%n", emailAdress);
      output += String.format("Home address: %s%n%n", homeAddress);
	    System.out.println(output);
	  }else{
	    System.out.print("--------------Contact not found----------------");
	  }
	  
	}


}
