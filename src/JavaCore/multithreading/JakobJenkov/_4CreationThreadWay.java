package JavaCore.multithreading.JakobJenkov;

public class _4CreationThreadWay {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running");
            System.out.println("MyThread finished");
        };

        Thread thread = new Thread(runnable, "The Thread");
        thread.start();
    }
}
