package JavaCore.multithreading.concurrent.locks.semaphore;

import java.util.concurrent.Semaphore;

public class Task implements Runnable{

    private final Semaphore semaphore;

    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        try {
            System.out.println(name + " semaphore available " + semaphore.availablePermits());

            semaphore.acquire();

            System.out.println(name + " semaphore.acquire()");
            System.out.println(name + " semaphore available " + semaphore.availablePermits());

            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println(name + " semaphore.release()");
            semaphore.release();
            System.out.println(name + " semaphore available " + semaphore.availablePermits());
        }

    }
}
