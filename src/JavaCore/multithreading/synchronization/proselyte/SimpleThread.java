package JavaCore.multithreading.synchronization.proselyte;

public class SimpleThread extends Thread{
  private Thread thread;
  private String threadName;
  Counter counter;

  public SimpleThread(String threadName, Counter counter) {
    this.threadName = threadName;
    this.counter = counter;
  }

  public void run(){
    System.out.println("Thread " + threadName + " is running...");
    //synchronized (counter){
      counter.displayCounter();
    //}
    System.out.println("Leaving " + threadName + " thread...");
  }

  public void start(){
    System.out.println("Thread " + threadName + " is started.");
    if(thread == null){
      thread = new Thread(this,threadName);
      thread.start();
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}