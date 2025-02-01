package diary_services;

import java.util.ArrayList;
import java.util.HashMap;

public class Diary {
    private       boolean        isLocked;
    final private HashMap<Integer, Entry> entries;
    private       int            entryId = 0;

    public Diary(String username, String password) {
        this.entries = new HashMap<>();
        this.isLocked = true;
    }

    public int getNoOfEntries() {
        return entries.size();
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlock() {
        isLocked = false;
    }

    public void lock() {
        isLocked = true;
    }

    public void createEntry(String title, String body) {
        int id = entryId++;
        Entry newEntry = new Entry(id, title, body);
        entries.put(id, newEntry);
    }

    public Entry findEntryById(int id) {
        Entry entry = entries.get(id);
        if (entry != null) {
            return entry;
        } else throw new IllegalArgumentException("ID " + id + " does not match any entry");
    }

    public void delete(int id) {
        Entry deletedEntry = entries.remove(id);
        if (deletedEntry == null) {
            throw new IllegalArgumentException("ID " + id + " does not match any entry");
        }
    }
}
