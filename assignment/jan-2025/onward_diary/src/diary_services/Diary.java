package diary_services;

import java.util.HashMap;

public class Diary {
    private       boolean                 isLocked;
    private final HashMap<Integer, Entry> entries;
    private       int                     entryId = 0;
    private       String                  username;
    private       String                  password;

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

    public void unlock(String password) {
        if (isPasswordValid(password)) {
            this.isLocked = false;
        } else throw new IllegalArgumentException("Passwords do not match, Try again to unlock");
    }

    public void lock() {
        isLocked = true;
    }

    public void createEntry(String title, String body) {
        if (this.isLocked) throw new IllegalStateException("Diary is locked, unlock to add new entry");
        int id = entryId++;
        Entry newEntry = new Entry(id, title, body);
        entries.put(id, newEntry);
    }

    public Entry findEntryById(int id) {
        if (this.isLocked) throw new IllegalStateException("Diary is locked, unlock to find entry");
        Entry entry = entries.get(id);
        if (entry != null) {
            return entry;
        } else throw new IllegalArgumentException("ID " + id + " does not match any entry");
    }

    public void delete(int id) {
        if (this.isLocked) throw new IllegalStateException("Diary is locked, unlock to delete entry");
        Entry deletedEntry = entries.remove(id);
        if (deletedEntry == null) {
            throw new IllegalArgumentException("ID " + id + " does not match any entry");
        }
    }

    public void updateEntry(int id, String title, String body) {
        if (this.isLocked) throw new IllegalStateException("Diary is locked, unlock to update entry");
        Entry entry = findEntryById(id);
        entry.updateBody(body);
        entry.updateTitle(title);
    }

    public void changeUsername(String username, String password) {
        if (this.isLocked) throw new IllegalStateException("Diary is locked, unlock to change username");
        if (isPasswordValid(password)) {
            this.username = username;
        } else throw new IllegalArgumentException("Passwords do not match");
    }

    public String getUsername() {
        return username;
    }

    public void changePassword(String newPassword, String oldPassword) {
        if (this.isLocked) throw new IllegalStateException("Diary is locked, unlock to change password");
        if (isPasswordValid(oldPassword)) {
            this.password = newPassword;
        } else throw new IllegalArgumentException("Passwords do not match");
    }

    public boolean isPasswordValid(String password) {
        return this.password.equals(password);
    }
}
