package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;


//Playtech
public class StringRearrangement {

    public static void main(String[] args) {
        List<String> cars = Arrays.asList("Golf", "Corvette", "Corvette", "X5", "Golf", "Golf");

        Map<String, Long> carCountMap = cars.stream()
                .collect(Collectors.groupingBy(car -> car, Collectors.counting()));

        PriorityQueue<Map.Entry<String, Long>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue().intValue() - a.getValue().intValue());
        maxHeap.addAll(carCountMap.entrySet());

        List<String> result = new ArrayList<>();

        Map.Entry<String, Long> prevEntry = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<String, Long> currentEntry = maxHeap.poll();
            result.add(currentEntry.getKey());

            if (prevEntry != null && prevEntry.getValue() > 0) {
                maxHeap.offer(prevEntry);
            }

            currentEntry.setValue(currentEntry.getValue() - 1);
            prevEntry = currentEntry.getValue() > 0 ? currentEntry : null;
        }

        System.out.println(result);

    }

}


