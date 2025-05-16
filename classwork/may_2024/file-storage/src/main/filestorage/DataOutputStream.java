package filestorage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStream {
    public static void main(String[] args) {
        File file = new File("/filestorage/file1.txt");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                DataOutputStream outputStream = new DataOutputStream(fileOutputStream);)
        {
            String word = "Praise the god";

                outputStream.write(word.getBytes());

        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
