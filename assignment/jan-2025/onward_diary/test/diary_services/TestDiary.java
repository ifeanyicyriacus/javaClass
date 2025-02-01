package diary_services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDiary {
    private       Diary    diary;
    private final String[] usernames        = {"username1", "username2", "username3"};
    private final String[] correctPasswords = {"password1", "password2", "password3"};
    private final String   wrongPassword    = "wrongPassword";
    private final String[] titles = {"title1", "title2", "title3"};
    private final String[] bodies = {"entry1", "entry2", "entry3"};
    private final int[] validIds = {0, 1};
    private final int invalidId = 100;

    @BeforeEach
    void setUp() {
        diary = new Diary(usernames[0], correctPasswords[0]);
        diary.unlock(correctPasswords[0]);
    }

    @Test
    void testDiary_canBeCreated() {
        assertEquals(0, diary.getNoOfEntries());
    }

    @Test
    void testDiary_canBeUnlocked() {
        diary.lock();
        assertTrue(diary.isLocked());
        diary.unlock(correctPasswords[0]);
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
                () -> diary.changePassword("newPassword", correctPasswords[0]));
        assertThrows(IllegalStateException.class,
                () -> diary.changeUsername("newPassword", correctPasswords[0]));
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
    void testDiary_canCreateEntryIfDiaryIs() {
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
    void testDiary_throwsExceptionIfNoEntryMatchIdIfDiaryIsLocked() {
        assertEquals(0, diary.getNoOfEntries());
        diary.createEntry(titles[0], bodies[0]);
        assertEquals(1, diary.getNoOfEntries());
        assertEquals(titles[0], diary.findEntryById(0).getTitle());
        assertEquals(bodies[0], diary.findEntryById(0).getBody());
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
    void testDiary_canChangeUsernameWhenCorrectPassword(){
        assertEquals(usernames[0], diary.getUsername());
        diary.changeUsername(usernames[1], correctPasswords[0]);
        assertEquals(usernames[1], diary.getUsername());
    }

    @Test
    void testDiary_canNotChangePasswordWithIncorrectPassword(){
        assertEquals(usernames[0], diary.getUsername());
        assertThrows(IllegalArgumentException.class,
                () -> diary.changeUsername(usernames[1], wrongPassword));
        assertNotEquals(usernames[1], diary.getUsername());
    }

    @Test
    void testDiary_canChangePasswordWhenCorrectPassword(){
        String oldPassword = correctPasswords[0];
        String newPassword = correctPasswords[1];
        diary.changePassword(newPassword, oldPassword);
    }

    @Test
    void testDiary_canNotChangePasswordWhenIncorrectPassword(){
        String oldPassword = correctPasswords[0];
        String newPassword = correctPasswords[1];
        assertThrows(IllegalArgumentException.class,
                () -> diary.changePassword(newPassword, wrongPassword));
        diary.changeUsername(usernames[1], oldPassword);
        assertEquals(usernames[1], diary.getUsername());

    }
}
