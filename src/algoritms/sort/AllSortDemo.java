package algoritms.sort;

import java.util.Arrays;

public class AllSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{9,1,8,2,7,3,6,4,5};
        int[] arr2 = new int[]{3,1,5,4,2};
        mergeSort(arr2);
        System.out.println("result = " + Arrays.toString(arr2));
    }

    private static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j]= arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }

    private static void insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;

        }
    }

    private static void mergeSort(int[] arr){
        int middle = arr.length / 2;
        if (arr.length <= 1) return;

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);


    }

    private static void merge(int[] array, int[] left, int[] right){
        int i = 0; int l = 0; int r = 0;

        while (left.length > l && right.length > r){
            if (left[l] > right[r]){
                array[i] = right[r];
                i++;
                r++;
            } else {
                array[i] = left[l];
                i++;
                l++;
            }
        }

        while (left.length > l){
            array[i] = left[l];
            i++;
            l++;
        }
        while (right.length > r){
            array[i] = right[r];
            i++;
            r++;
        }
    }
}
