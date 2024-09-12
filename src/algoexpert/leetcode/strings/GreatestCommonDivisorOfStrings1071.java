package algoexpert.leetcode.strings;

public class GreatestCommonDivisorOfStrings1071 {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABABAB", "AB"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int len = gcd(str1.length(), str2.length());
        return str1.substring(0, len);
    }

    private static int gcd(int length1, int length2) {
        if (length2 == 0){
            return length1;
        } else {
            int mod = length1 % length2;
            return gcd(length2, mod);
        }

    }
}
