import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main{
    private static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        welcomeHeader();
        login();

    }

    private static void login() {
        System.out.println("Login as Admin or Guest ");
        String userType = input.nextLine().toLowerCase();

        switch (userType){
            case "admin":
                goToAdminPortal();
                break;
            case "guest":
                goToGuestPortal();
                break;
            default:
                System.out.println("Enter a valid user type, try again");
        }
    }

    private static void logout() { main(new String[]{}); }

    private static void goToAdminPortal() {
        clearScreen();
        System.out.println("Enter Admin Password: ");
        String password = input.nextLine();
        if(password.equalsIgnoreCase("admin")){
            String menu = """
            Options:
            1. View All Rooms
            2. Manage Reservations
            3. Generate Reports
            4. Mark Rooms for Maintenance
            5. Add rooms
            6. View guest Details
            7. ->|Log out
            """;

            boolean isLogedIn = true;
            while (isLogedIn) {
                System.out.println(menu);
                int option = input.nextInt();

                switch (option) {
                    case 1 -> viewAllRooms();
                    case 2 -> manageReservations();
                    case 3 -> generateReports();
                    case 4 -> markRoomForMaintenance();
                    case 5 -> addRoom();
                    case 6 -> viewGuestDetails();
                    case 7 -> {
                        isLogedIn = false;
                        logout();
                    }
                    default -> System.out.println("Enter a valid option from (1-7).");
                }
            }

        }
        else {
            System.out.println("Enter a valid password");
        }


    }

    private static void clearScreen() {
        System.out.println("\033[H\033[2J");
    }

    private static void welcomeHeader() {
        System.out.println("Welcome, Madam Gloria!");
        String dateAndTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS").format(new Date());
        System.out.println(dateAndTime);
    }

}