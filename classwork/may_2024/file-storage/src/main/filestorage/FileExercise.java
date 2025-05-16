package filestorage;

import java.io.*;

public class FileExercise {
    public static void main(String[] args) {
        File file = new File("../mai");

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            User user = new User();
//            user.setFirstName("Ifeanyi");
//            user.setLastName("Cyriacus");
//            user.setEmail("ifeanyi@gmail.com");
//            user.setPassword("password");
//            objectOutputStream.writeObject(user);

            User foundUser = (User) objectInputStream.readObject();
            System.out.println(foundUser);

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
