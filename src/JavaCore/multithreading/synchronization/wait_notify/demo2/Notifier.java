package JavaCore.multithreading.synchronization.wait_notify.demo2;

public class Notifier implements Runnable {

    private Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");

        try {
            Thread.sleep(1000);
            synchronized (message) {
                message.setMessage(name + " поток Notifier отработал");
                message.notify();
                // message.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}