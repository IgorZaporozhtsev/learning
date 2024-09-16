package algoexpert.codewars;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class DisemvowelTrolls {

    public static void main(String[] args) {
        String disemvowel = disemvowel2("This website is for losers LOL!");
        System.out.println(disemvowel);
    }
    public static String disemvowel(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

    public static String disemvowel2(String str) {
        IntPredicate notVowelPredicate = character ->
                character != 'A' && character != 'a'
                        && character != 'E' && character != 'e'
                        && character != 'I' && character != 'i'
                        && character != 'O' && character != 'o'
                        && character != 'U' && character != 'u';

        return str.chars()
                .filter(notVowelPredicate)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
