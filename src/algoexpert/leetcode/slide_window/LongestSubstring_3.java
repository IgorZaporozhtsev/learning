package algoexpert.leetcode.slide_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring_3 {
    //3. Longest Substring without Repeating Characters
    public static void main(String[] args) {
        String s1 = "abcabcd";
        String s2 = " ";
        System.out.println(lengthOfLongestSubstring2(s1));

    }
    // brute force
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder currentSubstring = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (currentSubstring.indexOf(String.valueOf(s.charAt(j))) != -1){ //indexOf
                    break;
                }
                currentSubstring.append(s.charAt(j));
                if(currentSubstring.length() > maxLength){
                    maxLength = currentSubstring.length();
                }
            }
        }
        return maxLength;
    }

    //a b c a b c d
    public static int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0, left = 0; right < s.length(); right++) {
            char elem = s.charAt(right);
            if (map.containsKey(elem) && map.get(elem) >= left ){
                left = map.get(elem) + 1;
            }
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
            }
            map.put(elem, right);
        }
        return maxLength;
    }
}
