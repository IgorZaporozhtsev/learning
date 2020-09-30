package algoritms.seach;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
        Arrays.sort(arr);
        int index = binarySearch(arr, 67);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int elem) {

        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int middleIndex = low + (high - low) / 2;

            if (elem < arr[middleIndex]){
                high = middleIndex - 1;
            } else if (elem > arr[middleIndex]){
                low = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }
}
