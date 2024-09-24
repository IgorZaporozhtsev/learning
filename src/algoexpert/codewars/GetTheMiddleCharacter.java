package algoexpert.codewars;

import java.security.spec.PSSParameterSpec;

public class GetTheMiddleCharacter {
    public static void main(String[] args) {
        String test1 = getMiddle("test");
        String test2 = getMiddle("middle");
        String test3 = getMiddle("testing");
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);

    }

    public static String getMiddle(String word) {
        int index = word.length() / 2;
        String result = "";
        if (word.length() % 2 == 0){
                result = word.substring(index - 1, index + 1);
            } else {
                result = word.substring(index, index + 1);
            }

        return result;
    }
}
