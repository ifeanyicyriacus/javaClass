package diary_services;

import java.time.LocalDateTime;

public class Entry {
    final private int           ID;
    private       String        title;
    private       String        body;
    final private LocalDateTime DATE_CREATED;

    public Entry(int ID, String title, String body) {
        this.ID = ID;
        setTitle(title);
        setBody(body);
        this.DATE_CREATED = LocalDateTime.now();
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

    private void setTitle(String title) {
        if(title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title;
    }
    private void setBody(String body) {
        if(body.isEmpty()) throw new IllegalArgumentException("Body cannot be empty");
        this.body = body;
    }

    public String getDATE_CREATED() {
        return DATE_CREATED.getDayOfWeek().toString().substring(0, 2) + ", " +
                DATE_CREATED.getDayOfMonth() + ", " +
                DATE_CREATED.getMonthValue() + ", " +
                DATE_CREATED.getYear() +
                " (" + DATE_CREATED.getHour() + ":" + DATE_CREATED.getMinute() + ")";
    }

    public void updateTitle(String newTitle) {
        setTitle(newTitle);
    }

    public void updateBody(String newBody) {
        setBody(newBody);
    }
}
