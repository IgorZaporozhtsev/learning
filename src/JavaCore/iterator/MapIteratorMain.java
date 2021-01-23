package JavaCore.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorMain {
    public static void main(String[] args) {
        Map<String, String> popOfCities = new HashMap<>();
        popOfCities.put("Los Angeles", "13");
        popOfCities.put("Vancouver", "9");
        popOfCities.put("New York", "19");
        popOfCities.put("Sheffield", "1");
        popOfCities.put("Tokyo", "15");

        //EntrySet
        //KeySet

        Iterator<String> stringIterator = popOfCities.keySet().iterator();

        System.out.println(popOfCities.keySet());

        while (stringIterator.hasNext()) {
            String key = stringIterator.next();

            if (key.equals("Tokyo")) {
                stringIterator.remove();
            }

            System.out.println("finally: " + popOfCities.entrySet());
        }

/*
        Iterator<Map.Entry<String, String>> stringIterator = popOfCities.entrySet().iterator();
        while (stringIterator.hasNext()){
            Map.Entry<String, String> entry = stringIterator.next();

            System.out.println("EntrySet: " + popOfCities.entrySet());
            System.out.println("KeySet: " + popOfCities.keySet());
            System.out.println("Entry: " + entry);
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
            System.out.println("----------");
        }
*/
    }
}
