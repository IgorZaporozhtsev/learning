package tasks;

public interface I {
    default int getAnswer() {
        return 42;
    }
}
