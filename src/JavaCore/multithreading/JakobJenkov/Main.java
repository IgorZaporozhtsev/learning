package JavaCore.multithreading.JakobJenkov;

public class Main {
    public static void main(String[] args) {
        String s = new String();
    }

    interface A{
        default void test(){
            System.out.println("А");
        }
    }

    interface B{
        default void test(int w){
            System.out.println("B");
        }
    }

    class C implements A, B{

    }
}
