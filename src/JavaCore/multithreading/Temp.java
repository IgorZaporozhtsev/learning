package JavaCore.multithreading;

public class Temp {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new MyNewThread().start();
    }
}


class MyNewThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("running");
    }
}