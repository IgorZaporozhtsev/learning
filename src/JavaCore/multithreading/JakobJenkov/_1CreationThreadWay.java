package JavaCore.multithreading.JakobJenkov;

public class _1CreationThreadWay {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread is running");
            System.out.println("MyThread finished");
        }
    }

}
