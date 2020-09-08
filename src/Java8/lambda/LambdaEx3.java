package Java8.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaEx3 implements Comparator<String> {

    @Override
    public int compare(String firstStr, String secondStr) {
        return Integer.compare(firstStr.length(),secondStr.length());
    }


    public static void main(String[] args) {
     //   Arrays.sort(strings, new LengthStringComparator());
    }
}



