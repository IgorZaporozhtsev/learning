package algoexpert.codewars;

public class Arge {
    public static void main(String[] args) {
        //int i = nbYear(1000, 2, 50, 1200);
        int i = nbYear(1500, 5, 100, 5000);
        //int i = nbYear(1500000, 2.5, 10000, 2000000);
        System.out.println(i);
    }

    public static int nbYear(int p0, double percent, int aug, int p) {
        // your code
        //return p0 + (p0 * percent) + aug;

        int result = 0;
        int population = 0;
        while (p > population){
            population = (int) (p0 + p0 * percent/100 + aug);
            p0 = population;
            result++;
        }
        return result;
    }
}
