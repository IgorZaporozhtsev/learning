package design_patterns.singleton2;

public class SingletonApp {
    public static void main(String[] args) {

        final int size = 1000;
        Singleton arr[] = new Singleton[size];

        for (int i = 0; i < 1000; i++) {
            arr[i] = Singleton.getInstance();
        }

        System.out.println(Singleton.counter);
    }


   //Нужно создать
   //приватный конструктор
   //публичный статический метод
}


//Ленивая реализация Синглтона
class Singleton {
    static int counter = 0;
    private static Singleton instance;

    //private static volatile Singleton instance;  // код при многопоточности
    private Singleton() {
        counter++;
    }

    public static Singleton getInstance() {
        if (instance == null) {                         //при попытке создание второго экземпляра instance будет != null
            instance = new Singleton();
        }

        return instance;                                //и вернеться текущий обьект

    }
   /*

    public static Singleton getInstance() {         // код при многопоточности
        if (instance == null) {
            synchronized (Singleton.class) {
            if (instance == null){
                instance = new Singleton();
                }
            }
        }

        return instance;
    } }*/

}


//https://www.youtube.com/watch?v=u11nr3ifLd0