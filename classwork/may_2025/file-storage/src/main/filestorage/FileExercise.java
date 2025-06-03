package filestorage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileExercise {
    public static void main(String[] args) {
        File file = new File("/home/civm/Documents/Dynamite/javaClass/classwork/may_2024/file-storage/src/main/filestorage/ifeanyi.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            objectOutputStream.write(12);
            byte[] bytes = fileInputStream.readAllBytes();
            String message = new String(bytes);
            System.out.println(message);

            User user = new User();
            user.setFirstName("Ifeanyi");
            user.setLastName("Cyriacus");
            user.setEmail("ifeanyi@gmail.com");
            user.setPassword("password");
            objectOutputStream.writeObject(user);

            User foundUser = (User) objectInputStream.readObject();
            System.out.println(foundUser);

            byte[] bytesOne = new byte[5];
            int result = fileInputStream.readNBytes(bytesOne, 0, 5);
            System.out.println(Arrays.toString(bytesOne));
            String value = new String(bytesOne);
            System.out.println(value);
            System.out.println(result);
            System.out.println(file.getPath());
            Path paths = Paths.get("/home/civm/Documents/Dynamite/javaClass/classwork/may_2024/file-storage/src/main/filestorage/ifeanyi.txt");
            Files.createFile(paths);

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            System.err.println(exception.getMessage());
        }
    }
}
