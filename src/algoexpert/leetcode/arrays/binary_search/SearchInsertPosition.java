package algoexpert.leetcode.arrays.binary_search;

import java.util.Arrays;
import java.util.Map;

public class SearchInsertPosition {
    //35. Search Insert Position

    /*
     Input: nums = [1,3,5,6], target = 5
     Output: 2
     Input: nums = [1,3,5,6], target = 2
     Output: 1
     Input: nums = [1,3,5,6], target = 7
     Output: 4


    * */


    public static int searchInsert(int[] nums, int target) {
        System.out.println("target is "+target);
        int green = 0;
        int blue = nums.length - 1;

        while(green <= blue){
            int red = green + (blue - green)/2;
            if(target > nums[red]){
                green = red + 1;
            }else{
                blue = red - 1;
            }
        }
        return green;
    }

    public static void main(String[] args) {
        var integerMap = Map.of(
//                new int[]{1, 3}, 2
//                  new int[]{1, 3, 5, 6}, 0
                new int[]{1, 3, 5, 6}, 5
//                new int[]{1, 3, 5, 6}, 2
//                new int[]{1, 3, 5, 6}, 7
        );

        integerMap.forEach((nums, target) -> System.out.println
                ("Input: "+ Arrays.toString(nums) +" Output index is " + searchInsert(nums, target)));
    }

}
