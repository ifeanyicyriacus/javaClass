package diary_services;

import java.util.HashMap;

public class Diaries {
    private final HashMap<String, Diary> diaries;

    public Diaries() {
        diaries = new HashMap<>();
    }

    public void add(String username, String password)  throws IllegalArgumentException{
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username or password cannot be empty, try again.");
        }
        if (this.diaries.containsKey(username)) {
            throw new IllegalArgumentException("Username already exists, try another username.");
        } else {
            this.diaries.put(username, new Diary(username, password));
        }
    }

    public int size() {
        return this.diaries.size();
    }

    public Diary findByUsername(String username) throws IllegalArgumentException {
        if (username.isEmpty()) throw new IllegalArgumentException("Username cannot be empty");
        Diary diary = this.diaries.get(username);
        if (diary == null) {
            throw new IllegalArgumentException("There is no diary associated with the username (" + username + ").");
        }
        return diary;
    }

    public void delete(String username, String password) throws IllegalArgumentException {
        Diary diary = findByUsername(username);
        if (diary.isPasswordValid(password)){
            this.diaries.remove(username);
        } else throw new IllegalArgumentException(
                String.format("Your username (%s), and password (%s) does not match any Diary.", username, password));
    }


}
