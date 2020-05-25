package JavaCore.interfaces.interface_methods;

public interface Formula {
     String a = "Hello";


    static void staticMethod(int a){
        System.out.println(a + 2);
    }

    //Кроме абстрактного метода calculate интерфейс Formula также определяет метод по умолчанию (default) defaultSqrtMethod.
    // Классы, имплементирующие этот интерфейс, должны переопределить только абстрактный метод calculate.
    // Метод по умолчанию defaultSqrtMethod будет доступен без переопределения.


    int calculate(int a);


    default double defaultSqrtMethod(int a) {
        return Math.sqrt(a);
    }



}
