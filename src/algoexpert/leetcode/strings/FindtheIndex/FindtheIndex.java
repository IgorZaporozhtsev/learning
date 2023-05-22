package algoexpert.leetcode.strings.FindtheIndex;

public class FindtheIndex {
//28. Find the Index of the First Occurrence in a String
    /*
        Input: haystack = "sadbutsad", needle = "sad"
        Output: 0
        Explanation: "sad" occurs at index 0 and 6.
        The first occurrence is at index 0, so we return 0.
    */

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("aaa", "aaaaa"));
        System.out.println(strStr("mississippi", "issipi"));
        System.out.println(strStr("mississippi", "sipp"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        var chars = haystack.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int begin = needle.charAt(0);

            if (chars[i] == begin) {
                var substring = haystack.substring(i, i + needle.length());
                if (substring.equals(needle)) {
                    return i;
                }
            }
            if ((haystack.length() - i) == needle.length()) return -1;
        }
        return -1;
    }


}
