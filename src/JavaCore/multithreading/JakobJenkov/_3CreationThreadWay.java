package JavaCore.multithreading.JakobJenkov;

public class _3CreationThreadWay {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("MyThread is running");
                System.out.println("MyThread finished");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
