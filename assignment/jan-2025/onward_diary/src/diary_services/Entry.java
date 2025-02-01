package diary_services;

import java.time.LocalDateTime;

public class Entry {
    final private int           ID;
    private       String        title;
    private       String        body;
    final private LocalDateTime Date_CREATED;

    public Entry(int ID, String title, String body) {
        this.ID = ID;
        this.title = title;
        this.body = body;
        this.Date_CREATED = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getID() {
        return ID;
    }

    public String getDate_CREATED() {
        return Date_CREATED.toString();
//        later build a more user friendly date
//        Sat, 1st February, 2025 (07:13:21)AM
    }

    public void updateTitle(String newTitle) {
        this.title = newTitle;
    }

    public void updateBody(String newBody) {
        this.body = newBody;
    }
}
