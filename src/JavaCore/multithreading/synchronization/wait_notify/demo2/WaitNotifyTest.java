package JavaCore.multithreading.synchronization.wait_notify.demo2;

public class WaitNotifyTest {

    public static void main(String[] args) {
        Message message = new Message("обработать");

        Waiter waiter = new Waiter(message);
        new Thread(waiter,"waiter").start();

       /* Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();*/

        Notifier notifier = new Notifier(message);
        new Thread(notifier, "notifier").start();

        System.out.println("Стартовали все потоки");
    }

}