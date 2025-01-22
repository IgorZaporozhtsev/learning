package algoexpert.leetcode.two_pointers;

import java.util.Locale;
import java.util.stream.IntStream;

//125. Valid Palindrome
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("raceacar"));
        System.out.println(isPalindrome("a."));

    }

    public static boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder("");
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)){
                builder.append(c);
            }
        }
        String str = builder.toString().toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left <= right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
