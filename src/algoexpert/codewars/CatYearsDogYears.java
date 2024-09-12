package algoexpert.codewars;

import java.util.Arrays;

public class CatYearsDogYears {
    //107
    //https://www.codewars.com/kata/5a6d3bd238f80014a2000187/train/java

    public static void main(String[] args) {
        int[] ints = ownedCatAndDog(15, 15);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] ownedCatAndDog(final int catYears, final int dogYears) {
        int toCatAge = toRealAge(catYears, 4);
        int toDogAge = toRealAge(dogYears, 5);
        return new int[]{toCatAge, toDogAge};
    }

    private static int toRealAge(int realAge, int m) {
        int toAge = 0;

        if (realAge < 15) {
            return toAge;
        } else if (realAge <= 23) {
            toAge = toAge + 1;
        } else if (realAge <= 27) {
            toAge = toAge + 2;
        } else {
            toAge = (realAge - 24) / m + 2;
        }
        return toAge;
    }
}
