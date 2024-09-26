package algoexpert.leetcode.stack;

import java.util.Stack;

public class BaseballGame {
    //682. Baseball Game
    //https://leetcode.com/problems/baseball-game/description/

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println(calPoints(new String[]{"1","C"}));
    }
    private static int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();

        for (String record : operations) {
            switch (record){
                case "C" -> stack.pop(); //remove last elem
                case "D" -> { //multiply 2 * last record
                    String s = stack.peek();
                    int i = Integer.parseInt(s) * 2;
                    stack.push(s);
                    stack.push(String.valueOf(i));
                }
                case "+" -> { //add last 2 records
                    String s1 = stack.pop();
                    String s2 = stack.pop();

                    int i = Integer.parseInt(s1) + Integer.parseInt(s2);
                    stack.push(s2);
                    stack.push(s1);
                    stack.push(String.valueOf(i));
                }
                default -> stack.push(record); //add elem
            }
        }

        int i = 0;
        while (!stack.isEmpty()){
            String s = stack.pop();
            i += Integer.parseInt(s);
        }

        return i;
    }

}
