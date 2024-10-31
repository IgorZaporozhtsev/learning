package JavaCore.multithreading.concurrent.locks.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DemoClass {
    public static void main(String[] args) {
        binarySemaphore();
    }

    private static void binarySemaphore() {
        //Binary Semaphore can hold value 0 or 1
        //Це означає що бінарний Сємафор захишає доступ до єдиного спільного ресурсу і забезпечує взаємне виключення
        //що дозволяє лише одному потоку отримати доступ до критичног рксурсу одночасно
        Semaphore semaphore = new Semaphore(1);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Task(semaphore));
        executorService.execute(new Task(semaphore));
        executorService.shutdown();
    }
}
