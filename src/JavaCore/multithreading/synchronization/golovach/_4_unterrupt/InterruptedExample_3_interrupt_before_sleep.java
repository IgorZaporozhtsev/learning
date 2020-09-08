package JavaCore.multithreading.synchronization.golovach._4_unterrupt;

public class InterruptedExample_3_interrupt_before_sleep {

  /**
   *  we called interrupt and flag is turn on isInterrupted = true
   *  and when we invoke methods which (sleep, join) throws InterruptedException we get InterruptedException
   *  */
  public static void main(String[] args) {
    Thread.currentThread().interrupt();
    try {
      // but if we use Thread.interrupted() flag change to false
      //System.out.println(Thread.interrupted());
      Thread.sleep(Long.MAX_VALUE);
    } catch (InterruptedException e ){
      System.out.println("Interrupted by exception");
    }
  }

}
