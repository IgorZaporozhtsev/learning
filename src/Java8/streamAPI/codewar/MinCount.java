package Java8.streamAPI.codewar;

import java.util.Arrays;

public class MinCount {
    public static void main(String[] args) {
        int[] arr = {12, 32, 3, 316};
        System.out.println(findSmallestInt(arr));

    }

    public static int findSmallestInt(int[] array) {
        int arr = Arrays.stream(array)
                .min() //вернет OptionalInt
                .getAsInt();
        return arr;
    }
}
