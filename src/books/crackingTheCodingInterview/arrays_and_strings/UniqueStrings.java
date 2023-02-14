package books.crackingTheCodingInterview.arrays_and_strings;

import java.util.HashSet;
import java.util.List;

public class UniqueStrings {
    public static void main(String[] args) {
        System.out.println(isCharacterUnique2("Hello"));
    }

    //Solution 1
    private static boolean isCharacterUnique1(String str) {
        List<Character> list = str.chars()
                .mapToObj(c -> (char) c)
                .toList();

        var set = new HashSet<>(list);

        return set.size() == list.size();
    }

    //Solution 2 without addition
    private static boolean isCharacterUnique2(String str) {
        char[] chars = str.toCharArray();
        boolean[] char_set = new boolean[128];

        for (int i = 0; i < chars.length; i++) {
            char val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
