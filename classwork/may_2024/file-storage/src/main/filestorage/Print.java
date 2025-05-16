package filestorage;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Print {
    public static void main(String[] args) {
        String path = "/User/apple/hello.txt";

        try (
                PrintStream printStream = new PrintStream(path)
                ) {
            System.setOut(printStream);
            System.out.println("Ifeanyi wed Onyinye!");
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        }
    }
}
