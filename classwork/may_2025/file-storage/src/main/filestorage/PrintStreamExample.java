package filestorage;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamExample {
    public static void main(String[] args) {
        String path = "/home/civm/Documents/Dynamite/javaClass/classwork/may_2024/file-storage/src/main/filestorage/ifeanyi.txt";

        try (PrintStream printStream = new PrintStream(path)) {
            System.setOut(printStream);
            System.out.println("Hello World!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
