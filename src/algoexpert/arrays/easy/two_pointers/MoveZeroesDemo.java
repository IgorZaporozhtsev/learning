package algoexpert.arrays.easy.two_pointers;

import javax.naming.PartialResultException;
import java.util.Arrays;

public class MoveZeroesDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        System.out.println("");
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void moveZeroes(int[] nums) {

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            int temp = nums[l];
            if (nums[r] != 0){
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        }
    }
}
