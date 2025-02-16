import java.util.Scanner;

import static enums.NigeriaStateGeoPoliticalZonesFunctions.getGeoPoliticalZoneByState;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter state name:");
        String response = sc.nextLine();
        System.out.println("geopolitical zone is:");

        try {
            var zone = getGeoPoliticalZoneByState(response).name();
            System.out.println("'" + response + " state' belongs to '" + zone + "' geo political zone");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
