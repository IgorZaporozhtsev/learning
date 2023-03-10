package algoexpert.leetcode;

import java.util.HashMap;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("true = " + isValid("()"));
        System.out.println("true = " + isValid("()[]{}"));
        System.out.println("false = " + isValid("(]"));
        System.out.println("true = " + isValid("{[]}"));
        System.out.println("false = " + isValid("{[}}"));
        System.out.println("false = " + isValid("([)]"));
    }

    public static boolean isValid(String s) {
        var map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars[chars.length - 3]) return false;

            int count = 0;
            Character character = map.get(chars[i]);
            if (character == null) continue;
            for (int j = 1; j < chars.length; j++) {
                if (character == chars[j]) count++;
            }
            if (count == 0) return false;
        }

        return true;
    }
}
