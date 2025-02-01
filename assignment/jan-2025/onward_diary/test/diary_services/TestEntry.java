package diary_services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEntry {
    private Entry entry;

    private int id = 0;
    private String title = "Entry title";
    private String body = "Entry body";

    @BeforeEach
    void setUp() {
        entry = new Entry(id, title, body);
    }

    @Test
    void testEntry_canBeCreated() {
        assertEquals(id, entry.getID());
        assertEquals(title, entry.getTitle());
        assertEquals(body, entry.getBody());
        assertNotNull(entry.getDate_CREATED());
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
}
