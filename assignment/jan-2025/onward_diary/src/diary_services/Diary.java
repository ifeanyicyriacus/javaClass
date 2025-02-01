package diary_services;

import java.util.HashMap;

public class Diary {
    private        boolean                 isLocked;
    private final  HashMap<Integer, Entry> entries;
    private int                     entryId = 0;
    private        String         username;
    private        String         password;

    public Diary(String username, String password) {
        this.entries = new HashMap<>();
        this.isLocked = true;
        this.username = username;
        this.password = password;
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

    public void updateEntry(int id, String title, String body) {
        Entry entry = findEntryById(id);
        entry.updateBody(body);
        entry.updateTitle(title);
    }

    public void changeUsername(String username, String password) {
        if (this.password.equals(password)) {
            this.username = username;
        } else throw new IllegalArgumentException("Passwords do not match");
    }

    public String getUsername() {
        return username;
    }

    public void changePassword(String newPassword, String oldPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
        } else throw new IllegalArgumentException("Passwords do not match");
    }
}
