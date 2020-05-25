package JavaCore.multithreading.synchronization.golovach._4_unterrupt;

public class InterruptedExample_2_isInterrupted {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
          Thread myThread = Thread.currentThread();
          int k = 0;
          while (!myThread.isInterrupted()){

            k = k + 1;
            System.out.println("Hello: " + k);
            for (int i = 0; i < 1_000_000; i++);
          }
      }
    });

    thread.start();
    Thread.sleep(21);
    thread.interrupt();
  }

}
