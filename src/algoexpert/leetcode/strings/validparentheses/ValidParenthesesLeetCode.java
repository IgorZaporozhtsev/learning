package algoexpert.leetcode.strings.validparentheses;

import java.util.Stack;

public class ValidParenthesesLeetCode {

    public static void main(String[] args) {
        // in this task you string represent in Stack

        System.out.println("1. false = " + isValid("(("));
//        System.out.println("1. true = " + isValid("()"));
//        System.out.println("2. true = " + isValid("()[]{}"));
//        System.out.println("3. false = " + isValid("(]"));
//        System.out.println("4. true = " + isValid("{[]}"));

//        System.out.println("5. false = " + isValid("{[}}"));
        //       System.out.println("6. false = " + isValid("([)]"));


//        System.out.println("7. false = " + isValid("[{(}])"));
//        System.out.println("8. true = " + isValid("{[()]}"));
//        System.out.println("9. false = " + isValid("]"));
//        System.out.println("10. false = " + isValid("(){}}{"));
//        System.out.println("11. false = " + isValid("({{{{}}}))"));


    }

    public static boolean isValid(String s) {

        // Create a new stack to store the characters.
        Stack<Character> stack = new Stack<>();


        // convert string into char array and access the characters using for each loop.
        for (char ch : s.toCharArray()) {
            // check ch
            switch (ch) {
                // open bracket then push it in stack.
                // close bracket then pop the item and compare.
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')

                    // if the stack is empty then it means string have no open bracket.
                    // hence it is invalid.
                    {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }


        // After the loop we have to check one more condition.
        // return true only if the stack is empty.
        // if stack is not empty that means we have unused brackets.

        return stack.isEmpty();

    }
}