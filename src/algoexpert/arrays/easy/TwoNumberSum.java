package algoexpert.arrays.easy;

import java.util.*;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] twoNumberSum = twoNumberSum(new int[]{3, 5, -4, 8, -1, 1, 11, 6}, 10);
        int[] twoNumberSum2 = twoNumberSum2(new int[]{-1, 11}, 10);
        System.out.println(Arrays.toString(twoNumberSum));
    }


    public static int[] twoNumberSum2(int[] array, int targetSum) {
        var set = new HashSet<Integer>();

        for (int j : array) {

            // x + y = 10
            // y = 10 - x
            // if y in a hashtable we return x and y

            int y = targetSum - j;

            if (set.contains(y)) {
                return new int[]{y, j};
            } else {
                set.add(j);
            }


        }

        return new int[0];
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        for(int i = 0; i < array.length; i++){
            //[ 3, 5, -4, 8, 11, 1, -1, 6 ]
            //[ 3, 5, -4, 8, 11, 1, -1, 6 ]

            for(int j = i+1; j < array.length; j++){

                if(array[i] + array[j] == targetSum){
                    return new int[]{array[i], array[j]};

                }
            }

        }
        return new int[0];
    }
}
