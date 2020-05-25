package JavaCore.multithreading.synchronization.golovach._4_unterrupt;

public class InterruptedExample_4_interrupt_before_wait {

  /**
   *  we called interrupt and flag is turn on isInterrupted = true
   *  and when we invoke methods which (sleep, join) throws InterruptedException we get InterruptedException
   *  */
  public static void main(String[] args) {
    Thread.currentThread().interrupt();
    try {
      // but if we use Thread.interrupted() flag change to false
      //System.out.println(Thread.interrupted());
      Object lock = new Object();
      synchronized (lock){
        lock.wait();
      }
    } catch (InterruptedException e ){
      System.out.println("Interrupted by exception");
    }
  }

}

