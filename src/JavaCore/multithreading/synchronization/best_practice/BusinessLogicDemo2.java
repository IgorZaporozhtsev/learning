package JavaCore.multithreading.synchronization.best_practice;

public class BusinessLogicDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Processable process = new Processable(); // share one object between two threads

        Thread thread0 = new Thread(process::doFirstExternalCall);
        Thread thread1 = new Thread(process::doSecondExternalCall);

        thread0.start();
        thread1.start();

        thread0.join();
        thread1.join();
    }
}

class Processable {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void doFirstExternalCall() {
        System.out.println(Thread.currentThread().getName() + " : Execute some business logic ");
        synchronized (lock1){
            try {
                System.out.println(Thread.currentThread().getName() + " : Acquired lock and executing doFirstExternalCall");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " : Finished initial work in doFirstExternalCall");
                int i = 5;
                while (i > 0) {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()  + " : please wait, the first call is still processing...");
                    i--;
                }
                System.out.println(Thread.currentThread().getName() + " : Finished work in doFirstExternalCall");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : Interrupted");
            }
        }
    }

    public void doSecondExternalCall() {
        System.out.println(Thread.currentThread().getName() + " : Execute some business logic ");
        synchronized (lock2) {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " : Acquired lock and executing doSecondExternalCall");
                System.out.println(Thread.currentThread().getName() + " : Finished work in doSecondExternalCall");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : Interrupted");
            }
        }
    }
}