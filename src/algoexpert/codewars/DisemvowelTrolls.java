package algoexpert.codewars;

import java.util.Arrays;

public class DisemvowelTrolls {

    public static void main(String[] args) {
        String disemvowel = disemvowel("This website is for losers LOL!");
        System.out.println(disemvowel);
    }
    public static String disemvowel(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }
}
