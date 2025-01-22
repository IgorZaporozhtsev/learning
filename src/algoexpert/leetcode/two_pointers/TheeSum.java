package algoexpert.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 3Sum
public class TheeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        //int[] arr2 = {-2,-2, 0, 0, 2, 2};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(List.of());

        for (int i = 0; i < nums.length; i++) {
            int right = nums.length - 1;
            int left = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            while (left < right){
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum > 0){
                    right--;
                } else if (threeSum < 0){
                    left++;
                }else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    result.add(integers);
                    left++;

                    //this is the corner case preventing repeating [[-2, 0, 2], [-2, 0, 2]]
                    while (nums[left] == nums[left - 1] && left < right){
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
