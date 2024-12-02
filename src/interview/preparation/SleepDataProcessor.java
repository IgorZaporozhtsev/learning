package interview.preparation;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SleepDataProcessor {

    private static final int SLIDING_WINDOW_SECONDS = 10;

    private static class SensorData {
        String type;
        double value;
        long timestamp;

        SensorData(String type, double value, long timestamp) {
            this.type = type;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<SensorData> sensorQueue = new LinkedBlockingQueue<>();
        ExecutorService sensorExecutor = Executors.newFixedThreadPool(3);
        AtomicBoolean running = new AtomicBoolean(true);

        // Simulate sensors
        sensorExecutor.submit(() -> simulateSensor(sensorQueue, "movement", 1, 5, running));
        sensorExecutor.submit(() -> simulateSensor(sensorQueue, "temperature", 20, 25, running));
        //sensorExecutor.submit(() -> simulateSensor(sensorQueue, "movement", 2, 4, running));

        // Process sensor data
        processSensorData(sensorQueue, running);

        // Shutdown after 30 seconds
        //Thread.sleep(30000);
        running.set(false);
        sensorExecutor.shutdown();
    }

    private static void simulateSensor(BlockingQueue<SensorData> queue, String type, int minValue, int maxValue, AtomicBoolean running) {
        while (running.get()) {
            //System.out.println(" Streaming data is running - " + running.get());
            try {
                double value = minValue + Math.random() * (maxValue - minValue);
                SensorData data = new SensorData(type, value, Instant.now().toEpochMilli());
                queue.put(data);
                Thread.sleep(100); // Simulate sensor data every 0.5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void processSensorData(BlockingQueue<SensorData> sensorQueue, AtomicBoolean running) {
        List<SensorData> window = new ArrayList<>();
        ExecutorService processorExecutor = Executors.newSingleThreadExecutor();

        //processorExecutor.submit(() -> {
            while (running.get() || !sensorQueue.isEmpty()) {
                //System.out.println(" Process data is running - " + running.get());
                try {
                    // Consume sensor data
                    //System.out.println("before sensorQueue is " + sensorQueue.size());
                    SensorData data = sensorQueue.poll(10, TimeUnit.MILLISECONDS);
                    if (data != null) {
                        window.add(data);
                    }
                    //System.out.println("after sensorQueue is " + sensorQueue.size());

                    // Remove old data
                    long currentTime = Instant.now().toEpochMilli();
                    //window.forEach(sensorData -> System.out.println(currentTime - sensorData.timestamp));
                    window.removeIf(sensorData -> currentTime - sensorData.timestamp > SLIDING_WINDOW_SECONDS * 1000);
                    System.out.println("window is " + window.size());
                    // Calculate metrics every second
                    if (currentTime % 1000 < 200) { // Small buffer to process close to a second
                        calculateAndPrintMetrics(window);
                        //Thread.sleep(100); // Wait the rest of the second
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            processorExecutor.shutdown();
        //});
    }

    private static void calculateAndPrintMetrics(List<SensorData> window) {
        double avgTemperature = window.stream()
                .filter(d -> "temperature".equals(d.type))
                .mapToDouble(d -> d.value)
                .average()
                .orElse(0.0);

        double totalMovement = window.stream()
                .filter(d -> "movement".equals(d.type))
                .mapToDouble(d -> d.value)
                .sum();

        System.out.printf("Avg Temperature: %.2f, Total Movement: %.2f%n", avgTemperature, totalMovement);
    }
}