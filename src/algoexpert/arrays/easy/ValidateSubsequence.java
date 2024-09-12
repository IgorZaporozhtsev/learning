package algoexpert.arrays.easy;

import java.util.List;
import java.util.Objects;

public class ValidateSubsequence {

    public static void main(String[] args) {
        boolean isValid = isValidSubsequence2(
                List.of(1, 1, 6, 1),
                List.of(1, 1, 1, 6)
        );
        System.out.println(isValid);

        boolean compare1 = compare1("ad", "ad");
        boolean compare2 = compare2("ad", null);

        System.out.println("1 String is equal - " + compare1);
        System.out.println("2 String is equal - " + compare2);
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.

        int k = 0;

        for (Integer i: array) {
            if (k < sequence.size() && Objects.equals(i, sequence.get(k))){
                k++;
            }
        }

        return k == sequence.size();
    }

    public static boolean compare1(String str1, String str2) {
        return ((str1 == str2) || (str1 != null && str1.equals(str2)));
    }

    public static boolean compare2(String str1, String str2) {
        return (Objects.equals(str1, str2));
    }


    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence){
        int arrIdx = 0;
        int seqIdx = 0;

        while(arrIdx < array.size() && seqIdx < sequence.size()){
            if(array.get(arrIdx).equals(sequence.get(seqIdx))){
                seqIdx = seqIdx + 1;
            }
            arrIdx = arrIdx + 1;

        }
        return seqIdx == sequence.size();
    }
}
