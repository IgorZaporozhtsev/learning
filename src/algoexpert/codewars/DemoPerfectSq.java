package algoexpert.codewars;

public class DemoPerfectSq {
    public static void main(String[] args) {
        System.out.println(findNextSquare(114));

    }
    public static long findNextSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        if (sq % sqrt != 0) {
            return -1;
        }
        return (long) Math.pow(sqrt + 1, 2);
    }
}




