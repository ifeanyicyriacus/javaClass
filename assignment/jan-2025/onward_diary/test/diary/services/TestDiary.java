package diary.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDiary {
    private       Diary    diary;
    private final String[] usernames     = {"username1", "username2", "username3"};
    private final String[] Passwords     = {"password1", "password2", "password3"};
    private final String   wrongPassword = "wrongPassword";
    private final String[] titles = {"title1", "title2", "title3"};
    private final String[] bodies = {"entry1", "entry2", "entry3"};
    private final int[] validIds = {1, 2};
    private final int invalidId = 100;
    private final String empty = "";

    @BeforeEach
    void setUp() {
        diary = new Diary(usernames[0], Passwords[0]);
        diary.unlock(Passwords[0]);
    }

    @Test
    void testDiary_canBeCreated() {
        assertEquals(0, diary.getNoOfEntries());
    }

    @Test
    void testDiary_canNotBeCreatedWithEmptyOrNullUsernameOrPassword() {
        assertThrows(IllegalArgumentException.class,
                () -> new Diary(empty, Passwords[0]));
        assertThrows(IllegalArgumentException.class,
                () -> new Diary(null, Passwords[0]));
        assertThrows(IllegalArgumentException.class,
                () -> new Diary(usernames[1], empty));
        assertThrows(IllegalArgumentException.class,
                () -> new Diary(usernames[1], null));
    }

    @Test
    void testDiary_canBeUnlocked() {
        diary.lock();
        assertTrue(diary.isLocked());
        diary.unlock(Passwords[0]);
        assertFalse(diary.isLocked());
    }

    @Test
    void testDiary_canNotBeUnlockedWithWrongPassword() {
        diary.lock();
        assertThrows(IllegalArgumentException.class,
                () -> diary.unlock(wrongPassword));
    }

    @Test
    void testDiary_canNotPerformAnyOperationIfDiaryIsLocked() {
        diary.createEntry(titles[0], bodies[0]);
        assertEquals(1, diary.getNoOfEntries());
        diary.lock();

        assertThrows(IllegalStateException.class,
                () -> diary.createEntry(titles[1], bodies[1]));
        assertThrows(IllegalStateException.class,
                () -> diary.updateEntry(validIds[0], titles[0], bodies[0]));
        assertThrows(IllegalStateException.class,
                () -> diary.findEntryById(validIds[0]));
        assertThrows(IllegalStateException.class,
                () -> diary.delete(validIds[0]));
        assertThrows(IllegalStateException.class,
                () -> diary.changePassword("newPassword", Passwords[0]));
        assertThrows(IllegalStateException.class,
                () -> diary.changeUsername("newUsername", Passwords[0]));
    }

    @Test
    void testDiary_canBeLocked() {
        assertFalse(diary.isLocked());
        diary.lock();
        assertTrue(diary.isLocked());
    }

    @Test
    void testDiary_canNotPerformCRUDOperationIfLocked() {
        diary.lock();
        assertTrue(diary.isLocked());
        assertEquals(0, diary.getNoOfEntries());
        assertThrows(IllegalStateException.class,
                () -> diary.createEntry(titles[0], bodies[0]));
        assertEquals(0, diary.getNoOfEntries());
    }

    @Test
    void testDiary_canCreateEntryIfDiaryIsUnlocked() {
        assertFalse(diary.isLocked());
        assertEquals(0, diary.getNoOfEntries());
        diary.createEntry(titles[0], bodies[0]);
        assertEquals(1, diary.getNoOfEntries());
        diary.createEntry(titles[1], bodies[1]);
        assertEquals(2, diary.getNoOfEntries());
        assertEquals(titles[0], diary.findEntryById(validIds[0]).getTitle());
        assertEquals(bodies[0], diary.findEntryById(validIds[0]).getBody());
        assertEquals(titles[1], diary.findEntryById(validIds[1]).getTitle());
        assertEquals(bodies[1], diary.findEntryById(validIds[1]).getBody());
    }

    @Test
    void testDiary_throwsExceptionIfNoEntryMatchIdIfDiaryIsUnlocked() {
        assertEquals(0, diary.getNoOfEntries());
        diary.createEntry(titles[0], bodies[0]);
        assertEquals(1, diary.getNoOfEntries());
        assertEquals(titles[0], diary.findEntryById(validIds[0]).getTitle());
        assertEquals(bodies[0], diary.findEntryById(validIds[0]).getBody());
        assertThrows(IllegalArgumentException.class, () -> diary.findEntryById(invalidId));
    }

    @Test
    void testDiary_canDeleteEntry(){
        assertEquals(0, diary.getNoOfEntries());
        diary.createEntry(titles[0], bodies[0]);
        assertEquals(1, diary.getNoOfEntries());
        assertEquals(titles[0], diary.findEntryById(validIds[0]).getTitle());
        assertEquals(bodies[0], diary.findEntryById(validIds[0]).getBody());
        diary.delete(validIds[0]);
        assertEquals(0, diary.getNoOfEntries());
        assertThrows(IllegalArgumentException.class, () -> diary.findEntryById(validIds[0]));
    }

    @Test
    void testDiary_throwsExceptionWhenTryingToDeleteEntryThatDoesNotExist(){
        assertEquals(0, diary.getNoOfEntries());
        diary.createEntry(titles[0], bodies[0]);
        assertEquals(1, diary.getNoOfEntries());
        assertThrows(IllegalArgumentException.class,
                ()-> diary.delete(invalidId));
        assertEquals(1, diary.getNoOfEntries());
    }

    @Test
    void testDiary_canUpdateEntry(){
        assertEquals(0, diary.getNoOfEntries());
        diary.createEntry(titles[0], bodies[0]);
        assertEquals(1, diary.getNoOfEntries());
        assertEquals(titles[0], diary.findEntryById(validIds[0]).getTitle());
        assertEquals(bodies[0], diary.findEntryById(validIds[0]).getBody());
        diary.updateEntry(validIds[0], titles[1], bodies[1]);
        assertEquals(1, diary.getNoOfEntries());
        assertEquals(titles[1], diary.findEntryById(validIds[0]).getTitle());
        assertEquals(bodies[1], diary.findEntryById(validIds[0]).getBody());
    }

    @Test
    void testDiary_throwsExceptionWhenTryingToUpdateEntryThatDoesNotExist(){
        assertEquals(0, diary.getNoOfEntries());
        assertThrows(IllegalArgumentException.class,
                ()-> diary.updateEntry(invalidId, titles[1], bodies[1]));
    }

    @Test
    void testDiary_canChangeUsernameWhenCorrectPasswordIsGiven(){
        assertEquals(usernames[0], diary.getUsername());
        diary.changeUsername(usernames[1], Passwords[0]);
        assertEquals(usernames[1], diary.getUsername());
    }

    @Test
    void testDiary_canNotChangeUsernameWithIncorrectPassword(){
        assertEquals(usernames[0], diary.getUsername());
        assertThrows(IllegalArgumentException.class,
                () -> diary.changeUsername(usernames[1], wrongPassword));
        assertNotEquals(usernames[1], diary.getUsername());
    }

    @Test
    void testDiary_canChangePasswordWhenCorrectPasswordIsGiven(){
        String oldPassword = Passwords[0];
        String newPassword = Passwords[1];
        diary.changePassword(newPassword, oldPassword);
    }

    @Test
    void testDiary_canNotChangePasswordWhenIncorrectPassword(){
        String oldPassword = Passwords[0];
        String newPassword = Passwords[1];
        assertThrows(IllegalArgumentException.class,
                () -> diary.changePassword(newPassword, wrongPassword));
        diary.changeUsername(usernames[1], oldPassword);
        assertEquals(usernames[1], diary.getUsername());

    }

    @Test
    void testDiary_toStringDisplaysTheOverwrittenFormat() {
        for (int count = 1, splits = 2; count <= 3; count++, splits++) {
            diary.createEntry(titles[0], bodies[0]);
            assertEquals(diary.toString().split("title").length, splits);
        }
    }
}
