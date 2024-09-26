package algoexpert.codewars;

public class YouAreSquare {
    public static void main(String[] args) {
        System.out.println(isSquare(-1));
        System.out.println(isSquare(0));
        System.out.println(isSquare(3));
        System.out.println(isSquare(4));
        System.out.println(isSquare(25));
        System.out.println(isSquare(26));
    }

    private static boolean isSquare(int n) {
        if (n < 0) return false;
        if (n == 0) return true;
        double sqrt = Math.sqrt(n);
        if (n % sqrt == 0){
            return true;
        }
        return false;
    }
}
