package algoritms.sort;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {5, 1, 4, 2, 8};
    System.out.println(sort(arr));
  }

  public static String sort(int [] arr){

    for(int i = 0; i <= arr.length; i++){
      int tmp;

      if (i < (arr.length - 1) && arr[i] > arr[i + 1] && arr[i] != arr[i + 1] ){
        tmp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = tmp;
      }
    }

    return Arrays.toString(arr);
  }
}
