package JavaCore.multithreading.synchronization.golovach._4_unterrupt;

public class InterruptedExample_7_interrupt_when_sleep{

  public static void main(String[] args)  throws InterruptedException{
    Thread thread = new Thread(() -> {
      try {
        System.out.println("I'll sleep");
        Thread.sleep(Long.MAX_VALUE);
      } catch (InterruptedException e){
        System.out.println("I interrupted by exception");
      };
    });

    thread.start();
    Thread.sleep(3000);
    System.out.println("Wake up");
    thread.interrupt();
  }
}
