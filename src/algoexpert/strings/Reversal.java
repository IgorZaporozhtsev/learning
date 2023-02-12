package algoexpert.strings;

public class Reversal {
    public static void main(String[] args) {
        System.out.println(reverseString("Hello"));
    }

    public static String reverseString(String str) {
        if (str.equals("")) {
            return "";
        }
        String string = reverseString(str.substring(1));
        return string + str.charAt(0);
    }
}
