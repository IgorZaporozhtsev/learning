package algoexpert.leetcode.strings.FindtheIndex;

public class FindtheIndexTry {
//28. Find the Index of the First Occurrence in a String
    /*
        Input: haystack = "sadbutsad", needle = "sad"
        Output: 0
        Explanation: "sad" occurs at index 0 and 6.
        The first occurrence is at index 0, so we return 0.
    */


    //iterate through haystack
    //if  length of needle bigger than length of haystack return -1
    //check if haystack still eq needle chars
    //when we reach end of needle return haystack index


    public static void main(String[] args) {
      //  System.out.println(strStr("boom", "boom"));
       // System.out.println(strStr("aaa", "aaaaa"));
     //   System.out.println(strStr("hello", "ll"));
//       System.out.println(strStr("sadbutsad", "sad"));
//       System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("mississippi", "issipi"));
//        System.out.println(strStr("a", "a"));
//        System.out.println(strStr("mississippi", "sipp"));
    }

// m i s s i s s i p  p  i  - i s s i p i
// 1 2 3 4 5 6 7 8 9 10 11 -  1 2 3 4 5 6  = 5 + 1 length()
// need read + 1 that last char of haystack be equal needle chars

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j <  needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
                if (j == needle.length() -1){
                    return i;
                }
            }
        }
        return -1;
    }

}
