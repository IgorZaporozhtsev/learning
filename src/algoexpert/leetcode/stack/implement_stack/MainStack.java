package algoexpert.leetcode.stack.implement_stack;

public class MainStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(23);
        stack.push(21);
        stack.push(9);
        int param1 = stack.pop();
        int param2 = stack.pop();
        int param3 = stack.top();
        boolean param4 = stack.empty();
    }
}
