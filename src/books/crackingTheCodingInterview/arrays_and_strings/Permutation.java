package books.crackingTheCodingInterview.arrays_and_strings;

import java.util.Arrays;

public class Permutation {

    /*
         Input: s1 = "ab", s2 = "eidbaooo"
         Output: true
         Explanation: s2 contains one permutation of s1 ("ba").
    */
    public static void main(String[] args) {
        System.out.println("should be true: " + isPermutation("abd", "eidbaooo"));
        System.out.println("should be true: " + isPermutation("bd", "eidbaooo"));
        System.out.println("should be false: " + isPermutation("xewd", "eidbaooo"));
        System.out.println("should be false: " + isPermutation("eioo", "eidbaooo"));
        System.out.println("should be true: " + isPermutation("oooabdi", "eidbaooo"));
        System.out.println("should be true: " + isPermutation("oooabdie", "eidbaooo"));
        System.out.println("should be true: " + isPermutation("a", "ab"));
        System.out.println("should be true: " + isPermutation("ab", "ab"));
        System.out.println("should be true: " + isPermutation("abc", "bbbca"));
    }

    private static boolean isPermutation(String s1, String s2) {
        char[] s1chars = s1.toCharArray();
        Arrays.sort(s1chars);
        String s1sorted = new String(s1chars);

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            String s2substring = s2.substring(i, i + s1.length());

            char[] s2chars = s2substring.toCharArray();
            Arrays.sort(s2chars);

            String s2sorted = new String(s2chars);

            if (s1sorted.equals(s2sorted)) {
                return true;
            }
        }
        return false;

    }

}
