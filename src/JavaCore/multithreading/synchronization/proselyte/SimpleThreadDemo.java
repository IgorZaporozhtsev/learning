package JavaCore.multithreading.synchronization.proselyte;

public class SimpleThreadDemo {
  public static void main(String[] args) {
    Counter counter = new Counter();

    for (int k = 0; k < 10; k++) {
      SimpleThread simpleThread = new SimpleThread("Thread " + k, counter);
      simpleThread.start();
    }


    /*try {
      threadOne.join();
      threadTwo.join();
    }catch (InterruptedException e){
      System.out.println("Threads interrupted.");
      e.printStackTrace();
    }*/

    System.out.println("End of Main Thread");

  }
}