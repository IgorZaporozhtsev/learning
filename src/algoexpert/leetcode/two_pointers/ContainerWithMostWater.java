package algoexpert.leetcode.two_pointers;

//11. Container With Most Water
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,7,2,5,4,7,3,6}; //output 36
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        //(j - i) * min(heights[i], heights[j])

        int left = 0;
        int right = height.length - 1;
        int waterAmount = 0;
        int res = 0;

        while (left < right){
            waterAmount = (right - left) * Math.min(height[left], height[right]);
            if (waterAmount > res){
                res = waterAmount;
            }

            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }

        }
        return res;
    }

}
