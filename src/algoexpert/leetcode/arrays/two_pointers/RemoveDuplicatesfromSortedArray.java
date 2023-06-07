package algoexpert.leetcode.arrays.two_pointers;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

/*
  Input: nums = [1,1,2]
  Output: 2, nums = [1,2,_]
*/

    public static void main(String[] args) {
        int[] array = { 0,0,1,1,1,2,2,3,3,4 };
        System.out.println(removeDuplicates(array));
    }
  /*

    0,0,1,1,1,2,2,3,3,4

    0,1,1,1,1,2,2,3,3,4

    0,_,1,_,_,2,_ ,3,_,4

    0,1,2,3,4,_,_,_,_,_

 */


    public static int removeDuplicates(int[] nums) {

        int unique = 1;

        for(int i = 1; i<nums.length; i++) {

            var current = nums[i];
            var previous = nums[i - 1];

            if (current != previous) {
                nums[unique] = nums[i];
                unique++;
            }
            System.out.println(Arrays.toString(nums));
        }
        return unique;

    }
}
