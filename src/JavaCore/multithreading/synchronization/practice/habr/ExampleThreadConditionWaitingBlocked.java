package JavaCore.multithreading.synchronization.practice.habr;

public class ExampleThreadConditionWaitingBlocked {
  public static void main(String[] strings) throws InterruptedException {
    Object lock = new Object();

    Thread thread = new Thread() {
      @Override
      public void run() {
        try {
          synchronized (lock) {
            System.out.println("RUN_1");
            lock.notifyAll(); //2
            lock.wait(); //3
            System.out.println("RUN_2"); //6
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    synchronized (lock){
      thread.start(); // Запустим поток
      lock.wait(); // Будем ждать, пока поток не запустится //1
      System.out.println(thread.getState()); // WAITING //4
      lock.notifyAll(); //5
      System.out.println(thread.getState()); // BLOCKED //7
    }
  }
}
