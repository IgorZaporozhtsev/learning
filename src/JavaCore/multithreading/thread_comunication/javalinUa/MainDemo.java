package JavaCore.multithreading.thread_comunication.javalinUa;

public class MainDemo {

    public static void main(String[] args) throws InterruptedException {
        IntegerManger integerManger = new IntegerManger();

        Thread first = new Thread(() -> integerManger.getValue());
        Thread second = new Thread(() -> integerManger.setValue(23));

        first.start();
        second.start();

        first.join();
        second.join();
    }
}
