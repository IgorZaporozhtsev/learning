package algoexpert.leetcode.hashing;

import cources.stepic.base.tutorial.Main_2;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams49 {
    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = new String[]{"a"};
        System.out.println(groupAnagramsMap(strs));
        //output [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]];
    }

    public static List<List<String>> groupAnagramsMap(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            char[] notSortedChars = chars.clone();
            Arrays.sort(chars);
            if (map.get(Arrays.toString(chars)) == null){
                map.put(Arrays.toString(chars), new ArrayList<>());
            }
            map.get(Arrays.toString(chars)).add(new String(notSortedChars));

        }
        return new ArrayList<>(map.values());
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        ArrayList<List<String>> strings = new ArrayList<>();
        for (int i = 0; strs.length > i ;i++) {
            char[] ichars = strs[i].toCharArray();
            Arrays.sort(ichars);

            ArrayList<String> stList = new ArrayList<>();
            stList.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {
                char[] jchars = strs[j].toCharArray();
                Arrays.sort(jchars);

                if (Arrays.toString(ichars).equals(Arrays.toString(jchars))) {
                    System.out.println("equal");
                    stList.add(strs[j]);
                }
            }
            strings.add(stList);
        }
        List<List<String>> arrayLists = new ArrayList<List<String>>(strings);


        return arrayLists;
    }


}
