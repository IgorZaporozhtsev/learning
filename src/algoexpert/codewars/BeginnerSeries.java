package algoexpert.codewars;

public class BeginnerSeries {
    public static void main(String[] args) {
        System.out.println(getSum(1, 0));
        System.out.println(getSum(1, 2));
        System.out.println(getSum(0, 1));
        System.out.println(getSum(-1, 2));
        System.out.println(getSum(2, 4));
        System.out.println(getSum(4, 2));
        System.out.println(getSum(-1, 0));
    }

    public static int getSum(int a, int b){
        if (a == b) return a;

        return a < b ? getSumAcs(a,b) : getSumDes(a,b );
    }

    public static int getSumAcs(int a, int b) {
        //int count = Math.abs(a - b);

        int count = 0;
        for (int i = a; i <= b; i++) {
            count = count + i;
        }

        return count;
    }

    public static int getSumDes(int a, int b) {
        int count = 0;
        for (int i = a; i >= b; i--) {
            count = count + i;
        }

        return count;
    }



}
