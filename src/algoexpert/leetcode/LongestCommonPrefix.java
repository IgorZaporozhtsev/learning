package algoexpert.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {
                "flower", "flow", "flight"
        };

        String[] strs2 = {
                "a"
        };


        String s = longestCommonPrefix(strs2);
        String s2 = longestCommonPrefix2(strs);
        System.out.println(s2);
    }

    /*

    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    */
    private static String longestCommonPrefix(String[] strs) {

        if (strs.length == 1) return strs[0];

        for (int i = 0; i < strs[0].length(); i++) {
            String substring = strs[0].substring(0, strs[0].length() - i);

            int count = 0;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].startsWith(substring)) {
                    count++;
                    if (count == strs.length - 1) return substring;
                }
            }
        }
        return "";
    }

    public static String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
