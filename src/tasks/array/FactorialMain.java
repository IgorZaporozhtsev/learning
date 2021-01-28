package tasks.array;

public class FactorialMain {
    public static void main(String[] args) {
        System.out.println("factorial = " + factorial(5));

    }

    public static int factorial(int num) {
        //!5 = 1 * 2 * 3 * 4 * 5 = 120
        if (num == 0) return 1;

        int result = 1;

        for (int i = 1; i <= num; i++) {
            result = result * i;
        }

        return result;
    }
}
