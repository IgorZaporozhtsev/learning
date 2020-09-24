package design_patterns.chain_responsibility;

public class Chain_Responsibility {
    public static void main(String[] args) {
        Logger smsLogger = new SMSLogger(Level.ERROR);
        Logger fileLogger = new FileLogger(Level.DEBUG);
        Logger emailLogger = new EmailLogger(Level.INFO);

        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);

        smsLogger.writeMessageString("good", Level.INFO);
        smsLogger.writeMessageString("check", Level.DEBUG);
        smsLogger.writeMessageString("system error", Level.ERROR);
    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger{
    int priority;
    Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    void writeMessageString(String message, int level){
        if (level <= priority){
            write(message);
        }
        if (next != null){
            next.writeMessageString(message, level);
        }
    }

    protected abstract void write(String message);
}

class SMSLogger extends Logger{
    public SMSLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message){
        System.out.println("SMS: " + message);
    }
}

class FileLogger extends Logger{

    public FileLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message){
        System.out.println("write File: " + message);
    }
}

class EmailLogger extends Logger{

    public EmailLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message){
        System.out.println("Email sent: " + message);
    }
}
