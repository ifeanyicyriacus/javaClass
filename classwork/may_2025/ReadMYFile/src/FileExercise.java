//import java.io.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileExercise {
    public static void main(String[] args) {

//        File file = new File("./../../../../../../Screenshot from 2024-10-10 19-25-38.png");
//        System.out.println(file.isDirectory());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getPath());

//        try and catch while creating a file

        List<String> contents = List.of();
        try {

//            file input stream
//            file output stream
//            object output stream
//            object input stream
//            print stream

            Path paths = Paths.get("./storage/esther.txt");
            contents = Files.readAllLines(paths);
            Files.deleteIfExists(paths);
            Files.createFile(paths);
            Files.writeString(paths, "Hello World");
            Files.write(paths, contents);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(contents.getFirst());

        File file = new File("./storage/esther.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[7];
            int result = fileInputStream.readNBytes(bytes, 2, 4);
            System.out.println(Arrays.toString(bytes));
            String value = new String(bytes);
            System.out.println(value);
            System.out.println(result);

//            URI uri = URI.create("/storage/esther.txt");
//            File file = new File(uri);
//            FileInputStream fileInputStream =
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//calculator using go (request / jini framework)
//