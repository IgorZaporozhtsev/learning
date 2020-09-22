package JavaCore.multithreading.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 20; i++) {
            Thread1 thread1 = new Thread1();
            executorService.execute(thread1);
            executorService.scheduleAtFixedRate(thread1, 20000L, 20000L, TimeUnit.MINUTES);
        }
        executorService.shutdown();
    }

    static class Thread1 implements Runnable{

        @Override
        public void run() {
            System.out.println("Tread1 is running");
        }
    }
}
