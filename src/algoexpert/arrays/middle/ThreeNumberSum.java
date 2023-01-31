package algoexpert.arrays.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
       var threeNumberSum =
               threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8 ,6}, 0);

        threeNumberSum.forEach(array-> System.out.println(Arrays.toString(array)));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        var result = new ArrayList<Integer[]>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            int left = i + 1;
            int right = array.length - 1;


            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];

                if (currentSum < targetSum) {
                    left++;
                } else if (currentSum > targetSum) {
                    right--;
                } else {
                    result.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
