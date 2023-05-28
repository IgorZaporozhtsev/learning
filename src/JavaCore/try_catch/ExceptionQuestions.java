package JavaCore.try_catch;

public class ExceptionQuestions {

    public static void main(String[] args) throws Throwable {
        foo2();
        //foo1();
    }

    static class Person implements AutoCloseable{

        @Override
        public void close() throws Exception {
            throw new NullPointerException();
        }
    }

    private static void foo1() throws Throwable{
        Person person = new Person();
        try {
            throw new ArithmeticException();
        }finally {
            person.close();
        }
    }



    private static void foo2() throws Throwable{
        try (Person person = new Person()){
            throw new ArithmeticException();
        }
    }



}
