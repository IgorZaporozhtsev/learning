package JavaCore.iterator;

import java.util.*;

public class MapSortList {
    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(1);
        ids.add(1);
        ids.add(1);
        ids.add(2);
        ids.add(2);
        ids.add(2);
        ids.add(2);
        ids.add(2);
        ids.add(3);
        ids.add(3);
        ids.add(3);
        ids.add(3);
        ids.add(4);
        ids.add(4);
        ids.add(4);
        ids.add(4);
        ids.add(4);
        ids.add(4);
        ids.add(5);
        ids.add(5);
        ids.add(5);
        ids.add(5);
        ids.add(5);
        ids.add(5);
        ids.add(5);
        ids.add(5);
        ids.add(6);
        ids.add(6);
        ids.add(6);
        ids.add(6);
        ids.add(6);
        ids.add(6);
        ids.add(6);
        ids.add(6);
        ids.add(7);
        ids.add(7);
        ids.add(7);
        ids.add(7);
        ids.add(7);
        ids.add(7);
        ids.add(7);
        ids.add(7);
        ids.add(7);
        ids.add(8);
        ids.add(8);
        ids.add(8);
        ids.add(8);
        ids.add(8);
        ids.add(8);
        ids.add(8);
        ids.add(8);
        ids.add(8);
        ids.add(8);
        ids.add(8);

        printTopFive(ids);

        //top 5 more popular
    }

    public static void printTopFive(List<Integer> ids) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer id : ids) {
            if (map.get(id) != null && map.containsKey(id)) {
                map.put(id, map.get(id) + 1);
            } else {
                map.put(id, 1);
            }
        }

        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            System.out.println(en.getKey() + " : " + en.getValue());
        }

        map.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .limit(5)
            .forEach(System.out::print);


    }

}
