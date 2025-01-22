package algoexpert.leetcode.stack;

import java.util.Stack;

//150. Evaluate Reverse Polish Notation
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] strings = {"1", "2", "+", "3", "*", "4", "-"};
        System.out.println(evalRPN(strings));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
             switch (token){
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default ->  stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
