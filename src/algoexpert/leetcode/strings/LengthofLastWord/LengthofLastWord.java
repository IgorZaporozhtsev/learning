package algoexpert.leetcode.strings.LengthofLastWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthofLastWord {
    //58. Length of Last Word

/*

    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.

*/

    public static int lengthOfLastWord(String str) {
        var array = str.split(" ");
        return array[array.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon           "));
    }
}
