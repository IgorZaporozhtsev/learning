package JavaCore.multithreading.synchronization.wait_notify.demo2;

public class Message {
    // поле, с которым будут работать потоки через вызовы геттеров и сеттеров
    private String message;

    public Message(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String str) {
        this.message =str;
    }

}