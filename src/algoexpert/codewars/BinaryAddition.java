package algoexpert.codewars;

public class BinaryAddition {
    public static void main(String[] args) {
        System.out.println(binaryAddition(2, 2));
    }

    public static String binaryAddition(int a, int b){
        int sum = (a + b);
        String binaryString = Integer.toBinaryString(sum);
        return binaryString;
    }

}
