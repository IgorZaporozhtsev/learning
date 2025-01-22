package JavaCore.multithreading.synchronization.producer_consumer;

import java.util.LinkedList;
import java.util.List;

public class SyncBuffer {
    private final List<SyncItem> items = new LinkedList<>();
    private final int capacity;

    public SyncBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(SyncItem item) throws InterruptedException{
        //wait if the buffer is full
        while (items.size() == capacity){
            System.out.println("Buffer is full, producer waiting...");
            //this.wait();
            System.exit(0);
        }
        // Add the item to the buffer
        items.add(item);
        System.out.println("Added to buffer: ( " + items.size()+ " ) " +item);

        // Notify waiting consumers
        notifyAll();
    }

    public synchronized SyncItem get() throws InterruptedException {
        // Wait if the buffer is empty
        while (items.isEmpty()) {
            System.out.println("Buffer is empty, consumer waiting...");
            wait();
        }

        // Remove an item from the buffer
        SyncItem item = items.removeFirst();
        System.out.println("Consumer GET " + Thread.currentThread().getName());

        // Notify waiting producers
        notifyAll();

        return item;
    }
}
