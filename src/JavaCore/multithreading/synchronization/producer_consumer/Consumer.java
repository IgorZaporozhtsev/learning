package JavaCore.multithreading.synchronization.producer_consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Consumer implements Runnable {

    private final SyncBuffer buffer;
    String name;

    public Consumer(SyncBuffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        while (true) {
            try {
                // Retrieve an item from the buffer
                SyncItem item = buffer.get();

                // Simulate processing delay
                Random random = new Random();
                int number = random.nextInt(3 - 1 + 1) + 1;
                System.out.println("Consumer WAIT " +Thread.currentThread().getName()+ " busy at " + number + " sec");
                TimeUnit.SECONDS.sleep(number);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

