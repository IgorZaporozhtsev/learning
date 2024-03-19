package algoexpert.leetcode;

import java.util.Arrays;
import java.util.List;

public class TkachTask {
    public static void main(String[] args) {
        String[] strArr = {"yo", "no", "se"};
        List<String> strList = Arrays.asList(strArr);

        int[] intArr = {1,2,3};
        List<int[]> intList = Arrays.asList(intArr);

        System.out.println(strList.contains("yo") + " " + intList.contains(2));


    }
}
