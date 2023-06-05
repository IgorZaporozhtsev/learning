package algoexpert.leetcode.arrays;

import java.util.Arrays;
import java.util.Map;

public class RemoveElement {

    //27. Remove Element
    //Input: nums = [0,1,2,2,3,0,4,2], val = 2
    //Output: 5, nums = [0,1,4,0,3,_,_,_]
    public static int removeElement(int[] nums, int val) {
        System.out.println("input: "+ Arrays.toString(nums));
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!= val){
                nums[count]=nums[i];
                count++;
            }
        }
        System.out.println("output: " + Arrays.toString(nums) + "\n count: " + count);
        return count;
    }

    public static int removeElement1(int[] nums, int val) {


        if (nums.length == 1 && nums[0] == val){
            int arr []= { };
            nums = arr;
        } else if (nums.length == 1 && nums[0] != val){

        }

        int count = 0;
        int blue = nums.length - 1;

        for (int green = 0; green < nums.length; green++) {
            if (nums[blue] == val){
                if (blue != 0){
                    blue--;
                }
            }
            if (nums[green] == val) {
                nums[green] = nums[blue];
                if (blue != 0){
                    blue--;
                }
                count++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }


    public static void main(String[] args) {

        var integerMap = Map.of(
                 new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2,
                 new int[]{3, 2, 2, 3}, 3,
                 new int[]{1}, 1,
                 new int[]{2}, 3,
                 new int[]{3, 3},3,
                 new int[]{3, 1, 3, 3, 3},3
        );

        integerMap.forEach((k,v) -> removeElement(k,v));



    }
}
