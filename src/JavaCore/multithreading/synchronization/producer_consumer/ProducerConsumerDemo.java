package JavaCore.multithreading.synchronization.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerDemo {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        // Create the custom buffer with a capacity of 10
        SyncBuffer buffer = new SyncBuffer(10);

        // Create producer and consumer instances
        Producer producer = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer, "Consumer - 1");
        Consumer consumer2 = new Consumer(buffer, "Consumer - 2");
        Consumer consumer3 = new Consumer(buffer, "Consumer - 3");
        Consumer consumer4 = new Consumer(buffer, "Consumer - 4");
        Consumer consumer5 = new Consumer(buffer, "Consumer - 5");
        Consumer consumer6 = new Consumer(buffer, "Consumer - 6");
        Consumer consumer7 = new Consumer(buffer, "Consumer - 7");
        Consumer consumer8 = new Consumer(buffer, "Consumer - 8");
        Consumer consumer9 = new Consumer(buffer, "Consumer - 9");
        Consumer consumer10 = new Consumer(buffer, "Consumer - 10");

        // Submit tasks to the executor
        EXECUTOR_SERVICE.submit(producer);
        EXECUTOR_SERVICE.submit(consumer1);
        EXECUTOR_SERVICE.submit(consumer2);
        EXECUTOR_SERVICE.submit(consumer3);
        EXECUTOR_SERVICE.submit(consumer4);
        EXECUTOR_SERVICE.submit(consumer5);
        EXECUTOR_SERVICE.submit(consumer6);
        EXECUTOR_SERVICE.submit(consumer7);
        EXECUTOR_SERVICE.submit(consumer8);
        EXECUTOR_SERVICE.submit(consumer9);
        EXECUTOR_SERVICE.submit(consumer10);
    }
}
