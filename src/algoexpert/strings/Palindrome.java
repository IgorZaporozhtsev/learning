package algoexpert.strings;

public class Palindrome {
    public static void main(String[] args) {
        //System.out.println(isPalindrome("a b c d c b a"));
        boolean palindromeRecursion = isPalindromeRecursion("abcdcba");
        System.out.println(palindromeRecursion);
    }

    public static boolean isPalindrome(String str) {
        // Write your code here.

        boolean result = false;

        char[] chars = str.toCharArray();
        //int i = chars.length / 2;

        for (int j = 0; j < chars.length; j++) {
            result = chars[j] == chars[chars.length - j - 1];
            if (!result) return false;
        }

        return result;
    }

    public static boolean isPalindromeRecursion(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }

        System.out.println("first: " + str);
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            String substring = str.substring(1, str.length() - 1);

            return isPalindromeRecursion(substring);
        }

        return false;
    }

}
