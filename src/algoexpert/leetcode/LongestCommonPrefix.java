package algoexpert.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {
                "flower", "flow", "flight"
        };

        String[] strs2 = {
                "a"
        };


        String s = longestCommonPrefix(strs2);
        System.out.println(s);
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
}
