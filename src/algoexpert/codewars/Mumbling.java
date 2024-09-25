package algoexpert.codewars;

public class Mumbling {
    public static void main(String[] args) {
        System.out.println(accum("abcd"));
    }

    private static String accum(String s) {
        StringBuilder builder = new StringBuilder();
        String[] str = s.split("");
        for (int i = 0; i < str.length; i++) {
            char c = s.charAt(i);
            builder.append(String.valueOf(c).toUpperCase());
            builder.append(String.valueOf(c).toLowerCase().repeat(i));
            if (i != s.length() - 1) {
                builder.append("-");
            }
        }
        return builder.toString();

    }

}
