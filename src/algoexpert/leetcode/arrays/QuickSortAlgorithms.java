package algoexpert.leetcode.arrays;

import java.util.Arrays;

public class QuickSortAlgorithms {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 4, 7, 1, 3, 9, 6, 5};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] array, int start, int end){

    if (end <= start) return;

    int pivot = partition(array, start, end);
    quickSort(array, start, pivot - 1);
    quickSort(array, pivot + 1, end);


    }

    private static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }
}
