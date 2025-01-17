import java.util.Date;
import java.util.UUID;

public class Notification {
    private final UUID notificationID;
    private String               message;
    private NotificationType messageType;
    private Date                 date;

    public enum NotificationType {
        PRIORITY, ADVERTISEMENT, GENERAL, WARNING
    }

    public UUID getNotificationID() {
        return notificationID;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getMessageType() {
        return messageType;
    }
    public void setMessageType(NotificationType messageType) {
        this.messageType = messageType;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Notification(UUID notificationID, String message, NotificationType messageType) {

    }
}
