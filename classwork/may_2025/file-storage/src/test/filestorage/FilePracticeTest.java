package filestorage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FilePracticeTest {
    public String path;

    @BeforeEach
    public void setUp() {
        path = "/home/babayemi-mercy/projects/JavaClass/java/classtaskjava/may2025/filepractice/mercy.txt";
    }

    @AfterEach
    public void tearDown() {
        try {
            Files.deleteIfExists(Paths.get(path));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testThatCreateFileIfThePathToCreateIsNUllOrEmptyThrowsException(String path) {
        assertThrows(IllegalArgumentException.class, () -> FilePractice.createFile(path));
    }

    @Test
    public void testThatCreateFileIfThePathToCreateIsNotValidThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> FilePractice.createFile(path));
    }

    @Test
    public void testThatCreateFileCreateAndWhenWeFindItReturnsThePathOfTheFile() {
        FilePractice.createFile(path);
        File foundPath = FilePractice.findFileByPath(path);
        assertNotNull(foundPath);
    }

    @Test
    public void testThatDuplicateFileNameThrowsException() {
        FilePractice.createFile(path);
        assertThrows(IllegalArgumentException.class, () -> FilePractice.createFile(path));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testThatWriteToAFileIfTheFilePathIsNullOrEmptyThrowsException(String filePath) {
        assertThrows(IllegalArgumentException.class, () -> FilePractice.writeToFile(filePath, "Ifeanyi wed Onyi"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testThatWriteToAFileIfTheContentIsNullOrEmptyThrowsException(String content) {
        assertThrows(IllegalArgumentException.class, () -> FilePractice.writeToFile(content, "Ifeanyi wed Onyi"));
    }

    @Test
    public void testThatWriteToAFileIfThePathDoesNotExistThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> FilePractice.writeToFile(path, "Ifeanyi wed Onyi"));
    }

    @Test
    public void testThatWriteToAFileWithValidContentAndParametersAndFindTheContentOfFileShouldBeTheInput() {
        FilePractice.createFile(path);
        String word = "Hello World";
        FilePractice.writeToFile(path, word);
        String content = FilePractice.getContentInFile(path);
        assertNotNull(content);
        assertEquals(word, content);
    }

    @Test
    public void testThatWriteAMessageToAFileTwiceShouldHaveTheTwoOutput() {
        FilePractice.createFile(path);
        String word = "Hello World";
        FilePractice.writeToFile(path, word);
        String content = FilePractice.getContentInFile(path);
        assertNotNull(content);
        assertEquals(word, content);

        FilePractice.writeToFile(path, word);
        content = FilePractice.getContentInFile(path);
        assertNotNull(content);
        assertEquals(word + "\n" + word, content);
    }

    @Test
    void createFile() {
    }

    @Test
    void findFileByPath() {
    }

    @Test
    void writeToFile() {
    }

    @Test
    void getContentInFile() {
    }

    @Test
    void getValidUri() {
    }

    @Test
    void checkIfFileExist() {
    }


}