package algoexpert.codewars;

import java.util.HashMap;
import java.util.Map;

public class ExesAndOhs {
    public static void main(String[] args) {
        //System.out.println(getXO("ooxx"));
        //System.out.println(getXO("xooxx"));
        //System.out.println(getXO("ooxXm"));
        //System.out.println(getXO("zpzpzpp"));
        //System.out.println(getXO("zzoo"));
        System.out.println(getXO("Xxxxertr34"));

    }

    public static boolean getXO (String str) {

        String[] strings = str.toLowerCase().split("");
        Map<String, Integer> map = new HashMap<>();

        for (String s : strings) {
            if (map.containsKey(s)){
                map.compute(s, (k, i) -> i + 1);
            } else {
                map.put(s, 1);
            }
        }

        Integer o = map.get("o");
        Integer x = map.get("x");
        if (map.get("o") == null && map.get("x") == null){
            return true;
        }

        if (map.get("o") == null || map.get("x") == null){
            return false;
        }

        return o.equals(x);
    }
}
