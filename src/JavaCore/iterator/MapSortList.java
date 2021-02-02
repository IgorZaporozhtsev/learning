package JavaCore.iterator;

import java.util.*;

public class MapSortList {
    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            int random = (int) (Math.random() * 50 + 1);
            ids.add(random);
        }
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

//        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
//            System.out.println(en.getKey() + " : " + en.getValue());
//        }

        map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(5)
            .forEach(System.out::println);
    }
}
