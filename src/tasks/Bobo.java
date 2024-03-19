package tasks;

import java.util.List;

public class Bobo {

    public static void main(String[] args) {
        System.out.println(findMin(List.of(13, 34, 34, 16)));
    }

    private static int findMin(List<Integer> list){
        Integer minInt = list.get(0);
        for (Integer i: list) {
            if (i < minInt){
                minInt = i;
            }
        }
        return minInt;
    }
}
