package algoexpert.leetcode.two_pointers;

import java.util.Arrays;

//167. Two Sum II - Input Array Is Sorted
public class TwoSum_2 {
    public static void main(String[] args) {
        int [] arr1 = {2, 7, 11, 15};
        int [] arr2 = {2, 3, 4};
        int [] arr3 = {-1, 0};
        int [] arr4 = {0, 0, 3, 4};
        int [] arr5 = {5, 25, 75};
        System.out.println(Arrays.toString(twoSum(arr1, 9)));
        System.out.println(Arrays.toString(twoSum(arr2, 6)));
        System.out.println(Arrays.toString(twoSum(arr3, -1)));
        System.out.println(Arrays.toString(twoSum(arr4, 0)));
        System.out.println(Arrays.toString(twoSum(arr5, 100)));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int left = 0;
        int right = numbers.length - 1;

        while (left < right){
            if (numbers[left] + numbers[right] == target){
                result[0] = left + 1;
                result[1] = right + 1;
            }

            if (numbers[left] + numbers[right] > target){
                right--;
            } else {
                left++;
            }
        }

        return result;
    }

}
