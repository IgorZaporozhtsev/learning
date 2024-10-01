package algoexpert.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JadenCasingStrings {
    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
    }

    private static String toJadenCase(String phrase) {
        if (null == phrase || phrase.isEmpty()) return null;
        StringBuilder builder = new StringBuilder();
        String[] split = phrase.split(" ");
        for (int i = 0; i < split.length;i ++) {
            String upperCase = toCamelCase(split[i]);
            builder.append(upperCase);
            if (i < split.length - 1){
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    private static String toCamelCase(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public class JadenCase2 {
        public String toJadenCase(String phrase) {
            if (phrase == null || phrase.isEmpty()) {
                return null;
            }
            return Arrays.stream(phrase.split("\\s"))
                    .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                    .collect(Collectors.joining(" "));
        }
    }

}
