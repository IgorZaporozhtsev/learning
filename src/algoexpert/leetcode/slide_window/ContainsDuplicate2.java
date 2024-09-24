package algoexpert.leetcode.slide_window;

import java.util.HashSet;

public class ContainsDuplicate2 {
    // 219. Contains Duplicate II
    //https://leetcode.com/problems/contains-duplicate-ii/description/
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,0,0,1};
        int[] nums3 = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums1, 3));
        System.out.println(containsNearbyDuplicate(nums2, 1));
        System.out.println(containsNearbyDuplicate(nums3, 2));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (right - left > k){
                window.remove(nums[left]);
                left++;
            }
            if (window.contains(nums[right])){
                return true;
            } else {
                window.add(nums[right]);
            }
        }
        return false;
    }
}
