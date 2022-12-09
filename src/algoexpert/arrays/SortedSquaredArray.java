package algoexpert.arrays;

import java.util.Arrays;

public class SortedSquaredArray {
    public static void main(String[] args) {

        int[] arr8 = sortedSquaredArray2(new int[]{-7, -3, 1, 9, 22, 30});

        System.out.println("8 - " + Arrays.toString(arr8));
   }

    public static int[] sortedSquaredArray(int[] array) {

        int[] newArr = new int[array.length];

        int firstIndex = 0;
        int secondIndex = array.length - 1;


        for (int i = 0; i < array.length; i++){

            int first = Math.abs(array[firstIndex]);
            int second = Math.abs(array[secondIndex]);

            if (second > first) {
                int squared = second * second;
                secondIndex--;
                newArr[newArr.length - i - 1] = squared;
            } else {
                int squared = first * first;
                firstIndex++;
                newArr[newArr.length - i - 1] = squared;
            }
        }
        return newArr;
    }

    public static int[] sortedSquaredArray2(int[] array) {

        return Arrays.stream(array)
                .boxed()
                .mapToInt(Integer::intValue)
                .map(n -> n * n)
                .sorted()
                .toArray();
    }

}
