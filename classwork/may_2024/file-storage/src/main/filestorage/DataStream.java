package filestorage;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
    public static void main(String[] args) {
        File file = new File("/home/civm/Documents/Dynamite/javaClass/classwork/may_2024/file-storage/src/main/filestorage/ifeanyi.java");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream))
        {
            String word = "Praise God";
            dataOutputStream.write(word.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
