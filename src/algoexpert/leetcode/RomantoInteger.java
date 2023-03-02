package algoexpert.leetcode;

import java.util.Map;

public class RomantoInteger {
    public static void main(String[] args) {
        //System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    /*
            Symbol       Value
            I             1
            V             5
            X             10
            L             50
            C             100
            D             500
            M             1000

            Input: s = "LVIII"
            Output: 58
            Explanation: L = 50, V= 5, III = 3.

            Input: s = "MCMXCIV"
            Output: 1994
            Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.


    * */
    private static int romanToInt(String s) {
        var map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );


        char[] chars = s.toCharArray();
        int result = 0;
        char oldChar = 0;

        for (char aChar : chars) {

            //Input: s = "MCMXCIV"
            //Output: 1994
            //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

            if (oldChar == 'I' && aChar == 'X') {
                result = calculate(map, result, oldChar, aChar);
            } else if (oldChar == 'I' && aChar == 'V') {
                result = calculate(map, result, oldChar, aChar);
            } else if (oldChar == 'X' && aChar == 'L') {
                result = calculate(map, result, oldChar, aChar);
            } else if (oldChar == 'X' && aChar == 'C') {
                result = calculate(map, result, oldChar, aChar);
            } else if (oldChar == 'C' && aChar == 'D') {
                result = calculate(map, result, oldChar, aChar);
            } else if (oldChar == 'C' && aChar == 'M') {
                result = calculate(map, result, oldChar, aChar);
            } else {
                Integer x = map.get(aChar);
                result = result + x;
            }

            oldChar = aChar;

        }


        return result;
    }

    private static int calculate(Map<Character, Integer> map, int result, char oldChar, char aChar) {
        Integer current = map.get(aChar);
        Integer old = map.get(oldChar);
        int i = current - old;
        result = result + Math.abs(i) - old;
        return result;
    }
}


