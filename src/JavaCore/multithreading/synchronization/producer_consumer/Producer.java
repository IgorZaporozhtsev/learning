package JavaCore.multithreading.synchronization.producer_consumer;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

class Producer implements Runnable {

    private final SyncBuffer buffer;

    public Producer(SyncBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Create a new SyncItem
                SyncItem item = new SyncItem("Item", 2, LocalDateTime.now());

                // Add the item to the buffer
                buffer.put(item);

                // Simulate production delay
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

