package filestorage;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePractice {

    public static void createFile(String path) {
        try {
            if (path == null || path.isEmpty())
                throw new IllegalArgumentException("path cannot be null or empty");
            URI uri = getValidUri(path);
            Path foundPath = Path.of(uri.getPath());
            if (checkIfFileExist(foundPath))
                throw new IllegalArgumentException("Path already exists");
            Files.createFile(foundPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File findFileByPath(String path) {
        Path foundPath = Paths.get(path);
        return Files.exists(foundPath)
                ? new File(path)
                : null;
    }

    public static void writeToFile(String filePath, String content) {
        try {
            if (filePath == null || filePath.isEmpty())
                throw new IllegalArgumentException("path cannot be null or empty");
            if (content == null || content.isEmpty())
                throw new IllegalArgumentException("content cannot be null or empty");
            getValidUri(filePath);
            Path path = Path.of(filePath);
            if (!checkIfFileExist(path))
                throw new IllegalArgumentException("File path does not exist");
            else {
                String foundWord = Files.readString(path);
                content = foundWord.isEmpty() ? content : foundWord + "\n" + content;
            }
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String getContentInFile(String path) {
        try {
            getValidUri(path);
            Path foundPath = Path.of(path);
            if (!checkIfFileExist(foundPath))
                throw new IllegalArgumentException("file path does not exist");
            byte[] output = Files.readAllBytes(foundPath);
            return new String(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URI getValidUri(String path) {
        return URI.create(path);
    }

    public static boolean checkIfFileExist(Path filePath) {
        return Files.exists(filePath);
    }
}
