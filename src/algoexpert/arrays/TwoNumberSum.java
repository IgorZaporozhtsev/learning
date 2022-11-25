package algoexpert.arrays;

import java.util.Arrays;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] twoNumberSum = twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(twoNumberSum));
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
