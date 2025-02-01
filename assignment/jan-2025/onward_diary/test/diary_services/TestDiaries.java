package diary_services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDiaries {
    private Diaries diaries;
    String emptyField      = "";
    String username1       = "username1";
    String password1       = "password1";
    String username2       = "username2";
    String password2       = "password2";
    String unknownUsername = "username3";
    String UnknownPassword = "password3";

    @BeforeEach
    public void setUp() {
        diaries = new Diaries();
    }

    @Test
    public void testDiaries_canAddDiaryWithValidInput() {
        assertEquals(0, diaries.size());
        diaries.add(username1, password1);
        assertEquals(1, diaries.size());
        diaries.add(username2, password2);
        assertEquals(2, diaries.size());
    }

    @Test
    public void testDiaries_canNotAddDiaryIfUsernameOrPasswordIsEmptyAndThrowsException() {
        String emptyField = "";
        String username1 = "username1";
        String password1 = "password1";

        assertEquals(0, diaries.size());
        assertThrows(IllegalArgumentException.class,
                () -> diaries.add(emptyField, password1));
        assertThrows(IllegalArgumentException.class,
                () -> diaries.add(username1, emptyField));
        assertThrows(IllegalArgumentException.class,
                () -> diaries.add(emptyField, emptyField));
    }

    @Test
    public void testDiaries_canFindDiaryByUsername() {
        assertEquals(0, diaries.size());
        diaries.add(username1, password1);
        diaries.add(username2, password2);
        assertEquals(2, diaries.size());
        Diary diary = diaries.findByUsername(username1);
        assertEquals(username1, diary.getUsername());
        diary = diaries.findByUsername(username2);
        assertEquals(username2, diary.getUsername());
    }

    @Test
    public void testDiaries_findDiaryByUsernameThrowsExceptionIfUsernameIsNotPresent() {
        assertThrows(IllegalArgumentException.class,
                () -> diaries.findByUsername(emptyField));
        assertThrows(IllegalArgumentException.class,
                () -> diaries.findByUsername(unknownUsername));

    }

    @Test
    public void testDiaries_canDeleteDiary() {
        assertEquals(0, diaries.size());
        diaries.add(username1, password1);
        diaries.add(username2, password2);
        assertEquals(2, diaries.size());
        diaries.delete(username1, password1);
        assertEquals(1, diaries.size());
        assertThrows(IllegalArgumentException.class,
                () -> diaries.findByUsername(username1));
    }


    @Test
    public void testDiaries_canNotDeleteDiaryWithIncorrectCredentials() {
        assertEquals(0, diaries.size());
        diaries.add(username1, password1);
        diaries.add(username2, password2);
        assertEquals(2, diaries.size());

        assertThrows(IllegalArgumentException.class,
                () -> diaries.delete(unknownUsername, UnknownPassword));
        assertThrows(IllegalArgumentException.class,
                () -> diaries.delete(unknownUsername, password1));
        assertThrows(IllegalArgumentException.class,
                () -> diaries.delete(username1, UnknownPassword));
        assertEquals(2, diaries.size());

        diaries.delete(username1, password1);
        assertEquals(1, diaries.size());

    }

}
