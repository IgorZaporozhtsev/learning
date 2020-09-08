package cources.stepic.base.tutorial;

public class L_da {

    @FunctionalInterface
    interface NumericTest {
       boolean test(int n);
    }

    static class LambdaDemo2{
        public static void main(String[] args) {
            NumericTest nunericTest = (n) -> (n % 2) == 0;

            if (nunericTest.test(10)){
                System.out.println("Четное");
            }

            if (!nunericTest.test(9)){
                System.out.println("НЕ Четное");
            }

            NumericTest numericTest2  = (n) -> n >= 0;
            if (numericTest2.test(1)){
                System.out.println("НЕ отрицательное");
            }

        }

    }
}
