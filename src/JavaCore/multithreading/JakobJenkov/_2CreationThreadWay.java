package JavaCore.multithreading.JakobJenkov;

public class _2CreationThreadWay {

    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("MyThread is running");
            System.out.println("MyThread finished");
        }
    }
}
