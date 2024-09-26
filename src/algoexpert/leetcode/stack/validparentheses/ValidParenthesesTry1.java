package algoexpert.leetcode.stack.validparentheses;


import java.util.Stack;

public class ValidParenthesesTry1 {

    public static void main(String[] args) {
        System.out.println("1. true = " + isValid("()"));
        System.out.println("2. true = " + isValid("()[]{}"));
        System.out.println("3. false = " + isValid("(]"));
        System.out.println("4. true = " + isValid("{[]}"));
        System.out.println("5. false = " + isValid("{[}}"));
        System.out.println("6. false = " + isValid("([)]"));
        System.out.println("7. false = " + isValid("[{(}])"));
        System.out.println("8. true = " + isValid("{[()]}"));
        System.out.println("9. false = " + isValid("]"));
        System.out.println("10. false = " + isValid("(){}}{"));
        System.out.println("11. false = " + isValid("({{{{}}}))"));
    }

    private static boolean isValid(String strings) {
        Stack<Character> stack = new Stack<>();

        char[] chars = strings.toCharArray();


        for (char aChar : chars) {

            switch (aChar) {
                case '{', '(', '[' -> stack.push(aChar);
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }


            }
        }

        return stack.isEmpty();

    }
}