package diary_services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEntry {
    private Entry entry;

    private final int    id    = 0;
    private final String title = "Entry title";
    private final String body  = "Entry body";

    @BeforeEach
    void setUp() {
        entry = new Entry(id, title, body);
    }

    @Test
    void testEntry_canBeCreated() {
        assertEquals(id, entry.getID());
        assertEquals(title, entry.getTitle());
        assertEquals(body, entry.getBody());
        assertFalse(entry.getDATE_CREATED().isEmpty());
    }

    @Test
    void testEntry_titleCanBeUpdated() {
        assertEquals(id, entry.getID());
        assertEquals(title, entry.getTitle());
        String newTitle = "New Entry Title";
        entry.updateTitle(newTitle);
        assertNotEquals(title, entry.getTitle());
        assertEquals(newTitle, entry.getTitle());
        assertEquals(id, entry.getID());
    }

    @Test
    void testEntry_bodyCanBeUpdated() {
        assertEquals(id, entry.getID());
        assertEquals(body, entry.getBody());
        String newBody = "New Entry Body";
        entry.updateBody(newBody);
        assertNotEquals(body, entry.getBody());
        assertEquals(newBody, entry.getBody());
        assertEquals(id, entry.getID());
    }

    @Test
    void testEntry_bodyCanNotBeUpdatedWithEmptyBody() {
        assertThrows(IllegalArgumentException.class, () -> entry.updateBody(""));
        assertEquals(body, entry.getBody());
    }

    @Test
    void testEntry_titleCanNotBeUpdatedWithEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> entry.updateTitle(""));
        assertEquals(title, entry.getTitle());
    }
}
