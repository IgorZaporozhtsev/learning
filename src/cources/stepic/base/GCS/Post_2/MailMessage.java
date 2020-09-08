package cources.stepic.base.GCS.Post_2;

public class MailMessage implements Sendable <String>{
    String from;
    String to;
    String content;

    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }
}
