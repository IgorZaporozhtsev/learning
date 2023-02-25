package books.crackingTheCodingInterview.arrays_and_strings;

public class OneAway {

    public static void main(String[] args) {
        System.out.println("Should be true: " + isOneAway("pale", "ple")); //ok
        System.out.println("Should be true: " + isOneAway("pales", "pale")); //ok
        System.out.println("Should be true: " + isOneAway("pale", "bale"));
        System.out.println("Should be false: " + isOneAway("pale", "bake"));
        System.out.println("Should be true: " + isOneAway("abcde", "abfde"));
        System.out.println("Should be false: " + isOneAway("abc", "def"));
        System.out.println("Should be true: " + isOneAway("abcde", "abde"));

        System.out.println("Should be true: " + isOneAway("abcde", "abcdef"));
        System.out.println("Should be false: " + isOneAway("", ""));

    }

    private static boolean isOneAway(String first, String second) {
        if (first.length() - second.length() == 1 ||
                second.length() - first.length() == 1) return true;

        int occurrence = 0;
        char[] first_chars = first.toCharArray();
        char[] second_chars = second.toCharArray();

        for (int i = 0; i < first_chars.length; i++) {
            if (first_chars[i] != second_chars[i]) {
                occurrence++;
            }
        }
        return occurrence == 1;
    }
}
