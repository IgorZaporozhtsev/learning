package design_patterns.singleton3;

public class JavaSingleton {

    private JavaSingleton() {
    }

    private static final  JavaSingleton INSTANCE = new JavaSingleton();

    public static JavaSingleton getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        System.out.println(getInstance());
    }

}
