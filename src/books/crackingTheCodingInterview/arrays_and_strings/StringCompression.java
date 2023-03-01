package books.crackingTheCodingInterview.arrays_and_strings;

import java.util.HashMap;

public class StringCompression {

    /*
       Input: chars = ["a","a","b","b","c","c","c"]
       Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
       Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
    */
    public static void main(String[] args) {

        char[] chars = {
                'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'
        };
        System.out.println(compress(chars));

    }

    /*
    1
         - track first
         - compare with next
         - count times
         - save to new array
         - if next different track it

    2 HashMap
        Input: chars = ["a","a","b","b","c","c","c"]
        key = a; value = 2
        key = b; value = 2
        key = c; value = 3


        */
    private static int compress(char[] chars) {

        var map = new HashMap<Character, Integer>();
        int count = 0;
        char tracked = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if (tracked == chars[i]) {
                count = count + 1;
            } else {
                count = 1;
                tracked = chars[i];
            }
            map.put(chars[i], count);
        }

        System.out.println(map);
        var strBuilder = new StringBuilder();

        map.forEach((k, v) ->
                strBuilder.append(k).append(v)
        );


        return strBuilder.toString().length();
    }
}
