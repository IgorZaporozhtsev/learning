package algoexpert.codewars;

import java.util.Arrays;
import java.util.HashSet;

public class TwoToOne {
    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
        System.out.println(longest("aretheyhere", "yestheyarehere"));
        System.out.println(longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
    }

    public static String longest (String s1, String s2) {
        String str = String.join("", s1, s2);
        String[] split = str.split("");
        HashSet<Object> set = new HashSet<>(Arrays.asList(split));
        StringBuilder builder = new StringBuilder();
        set.forEach(builder::append);
        return builder.toString();
    }
}
