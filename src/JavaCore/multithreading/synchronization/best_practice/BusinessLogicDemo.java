package JavaCore.multithreading.synchronization.best_practice;

public class BusinessLogicDemo {
    /***
     Thread-0 Acquired lock of Process class and not allow execute in parallel doSecondExternalCall by Thread-1.
     Resole this issue we need:
     1. Create two Objects as a lock
            private final Object lock1 = new Object();
            private final Object lock2 = new Object();
     2. Use separate synchronized block

     @see BusinessLogicDemo2

    */

    public static void main(String[] args) throws InterruptedException {
        Process process = new Process(); // share one object between two threads

        Thread thread0 = new Thread(process::doFirstExternalCall);
        Thread thread1 = new Thread(process::doSecondExternalCall);

        thread0.start();
        thread1.start();

        thread0.join();
        thread1.join();
    }
}

class Process {

    public synchronized void doFirstExternalCall() {
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
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " : Interrupted");
        }
    }

    public synchronized void doSecondExternalCall() {
        try{
            Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " : Acquired lock and executing doSecondExternalCall");
        System.out.println(Thread.currentThread().getName() + " : Finished work in doSecondExternalCall");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " : Interrupted");
        }
    }
}