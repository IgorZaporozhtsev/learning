package algoexpert.leetcode.two_pointers;

import JavaCore.collection.stack.SimpleStack;
import JavaCore.collection.stack.Stack;

public class BackspaceStringCompare {
    //844. Backspace String Compare
    //https://leetcode.com/problems/backspace-string-compare/description/

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));

    }

    public static boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
    }

    private static String backspace(String str){
        StringBuilder stringBuilder = new StringBuilder();
        char[] strArray = str.toCharArray();
        for (char c : strArray) {
            if (c != '#'){
                stringBuilder.append(c);
            }
            else if (!stringBuilder.isEmpty()){ // if c == #
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        return stringBuilder.toString();
    }
}
