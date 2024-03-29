package algoexpert.leetcode.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] inputArray = new int[]{2,7,11,1};
        int[] resultArray = twoSum2(inputArray, 9);
        System.out.println(Arrays.toString(resultArray));


    }

    private static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
           map.put(nums[i], i);
        }
        return new int[]{};
    }

    private static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.isEmpty()){
                Integer integer = map.get(target - nums[i]);
                if (integer != null){
                    System.out.println("got it");
                    return new int[]{integer, i};
                }
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
