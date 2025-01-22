package JavaCore.multithreading.synchronization.producer_consumer;

import java.time.LocalDateTime;

public class SyncItem {

    private String description;
    private int quantity;
    private LocalDateTime createdAt;

    public SyncItem(String description, int quantity, LocalDateTime createdAt) {
        this.description = description;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SyncItem{" +
                "description='" + description + '\'' +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                '}';
    }
}
