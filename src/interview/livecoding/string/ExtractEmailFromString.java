package interview.livecoding.string;

public class ExtractEmailFromString {
    // extract email from string
    public static void main(String[] args) {
        var dirtyString = "Johnny Depp <johnny-depp@gmail.com>";
        var cleanString = "johnny-depp@gmail.com";

        System.out.println(getRidOf(dirtyString));
        //output: johnny-depp@gmail.com
    }

    private static String getRidOf(String str) {
        int index = str.indexOf("<");
        return str.substring(index + 1, str.length() - 1);
    }


}
