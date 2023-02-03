package interview.livecoding.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRepeatInString {
    // fin repeat in String
    public static void main(String[] args) {
        String repeat = "aqwertyuiopa";
        System.out.println("1st approach - " + ifRepeatableCharactersExist_1(repeat));
        System.out.println("2nd approach - " + ifRepeatableCharactersExist_2(repeat));
    }


    private static boolean ifRepeatableCharactersExist_1(String str) {
        List<Character> listChars = str.chars()
                .mapToObj(c -> (char) c)
                .toList();

        Set<Character> setChars = new HashSet<>(listChars);

        return listChars.size() != setChars.size();
    }

    private static boolean ifRepeatableCharactersExist_2(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) return true;
            }
        }
        return false;
    }
}
