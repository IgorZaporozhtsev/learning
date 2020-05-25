package cources.stepic.base.tutorial.Generics;

public class GenericsMethods {
    public static void main(String[] args) {

        // Используя один метод mock мы получаем и возвращаем что хотим
        Integer i = GenericsMethodsTest.mock(1); //метод получает Integer i = 1 и возращает Integer
        String s = GenericsMethodsTest.mock("Hello"); //метод получает String s = "Hello" и возращает String
    }

    /*метод вернет тоже самое что и получит   */
    public static class GenericsMethodsTest {
        public static <T> T mock(T agr) {
            return null;
        }
    }
}
