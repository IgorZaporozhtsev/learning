package books.crackingTheCodingInterview.arrays_and_strings;

public class URLify {
    public static void main(String[] args) {
        System.out.println(replaceSpace("Mr John Smith"));
    }

    private static String replaceSpace(String input) {
        String substitute = "%20";
        char[] result = new char[input.length() + substitute.length() + 1];

        char[] charsSub = substitute.toCharArray();

        char[] chars = input.toCharArray();
        for (int i = 0, j = 0; i < chars.length; i++) {

            if (chars[i] != ' ') {
                result[j] = chars[i];
            } else {
                result[j] = charsSub[0];
                j++;
                result[j] = charsSub[1];
                j++;
                result[j] = charsSub[2];
            }
            j++;

        }
        return new String(result).trim();
    }
}
