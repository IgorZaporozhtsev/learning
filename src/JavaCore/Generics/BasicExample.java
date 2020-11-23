package JavaCore.Generics;

public class BasicExample {
    public static void main(String[] args) {
        // параметризация типом Integer

        Message<String, Text> ob2 = new Message<>();
        ob2.setValue("text", new Text());
        Text notification = ob2.getNotification();
        notification.getText();

    }
}

class Notification {

}

class Text extends Notification {
    String text;

    void getText() {
        System.out.println(text);
    }
}

class Message<String, T extends Notification> extends Notification {
    private T notification;
    private String message;

    public Message() {
    }

    public Message(T notification) {
        this.notification = notification;
    }

    public T getNotification() {
        return notification;
    }

    public void setValue(String value, T notification) {
        this.notification = notification;
    }
}



