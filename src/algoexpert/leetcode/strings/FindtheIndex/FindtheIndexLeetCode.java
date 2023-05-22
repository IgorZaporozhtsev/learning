package algoexpert.leetcode.strings.FindtheIndex;

public class FindtheIndexLeetCode {
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
        if (needle == "") return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }


}
