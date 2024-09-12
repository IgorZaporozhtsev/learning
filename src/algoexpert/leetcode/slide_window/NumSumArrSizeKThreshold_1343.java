package algoexpert.leetcode.slide_window;

public class NumSumArrSizeKThreshold_1343 {
    //1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,2,2,2,5,5,5,8};
        int[] arr2 = new int[]{11,13,17,23,29,31,7,5,2,3};
        //int case1 = numOfSubarrays(arr1, 3, 4);
        int case2 = numOfSubarrays(arr2, 3, 5);
        System.out.println(case2);
    }

    private static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int result = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }

        if (sum / k  >= threshold){
            result++;
        }

        for (int i = k; i < arr.length; i++){
            int left = arr[i - k];
            sum = sum - left;
            int right = arr[i];
            sum = sum + right;

            if (sum / k  >= threshold){
                result++;
            }
        }


        return result;
    }


}
