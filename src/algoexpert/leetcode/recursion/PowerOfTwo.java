package algoexpert.leetcode.recursion;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(6));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));

    }

    private static boolean isPowerOfTwo(int n){
        if (n == 0) return true;
        if (n == 1) return false;
        if (n % 2 == 0) {
            return isPowerOfTwo(n / 2);
        } else {
            return false;
        }

    }
}
