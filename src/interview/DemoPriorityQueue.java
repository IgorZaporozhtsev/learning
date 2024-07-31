package interview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DemoPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(String::length));

        priorityQueue.add("Rob");
        priorityQueue.add("Andrew");
        priorityQueue.add("John");

        while (!priorityQueue.isEmpty()) {
            String remove = priorityQueue.remove();
            System.out.println(remove);
        }
    }
}
