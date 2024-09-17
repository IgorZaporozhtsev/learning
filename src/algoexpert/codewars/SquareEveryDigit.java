package algoexpert.codewars;

import java.util.stream.Collectors;

public class SquareEveryDigit {
    //https://www.codewars.com/kata/546e2562b03326a88e000020/train/java

    public static void main(String[] args) {
        System.out.println(squareDigits(9119));
    }

    public static int squareDigits(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = Integer.valueOf(n).toString().toCharArray();
        for (char c : charArray) {
            int i = Integer.parseInt(String.valueOf(c));
            int result = (int) Math.pow(i, 2);
            stringBuilder.append(result);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public int squareDigits2(int n) {
        return Integer.parseInt(String.valueOf(n)
                .chars()
                .map(i -> Integer.parseInt(String.valueOf((char) i)))
                .map(i -> i * i)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));
    }
}
