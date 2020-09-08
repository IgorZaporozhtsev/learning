package JavaCore.multithreading.ComputerScienceCenter.demo1;

/**
 * Example how create thread
 *
 * */

public class Demo1 {

  public static void main(String[] args) {

    //Thread approach
 /*   for (int i = 0; i < 10; i++) {
      Thread helloThread = new HelloThread();
      helloThread.start();
    }*/

    //Runnable approach
    for (int i = 0; i < 10; i++) {
      HelloThreadRunnable threadRunnable = new HelloThreadRunnable();
      Thread helloRunnableThread = new Thread(threadRunnable);
      helloRunnableThread.start();
    }

    System.out.println("Hello from Main thread");
  }


  //Thread approach
  public static class HelloThread extends Thread {

    @Override
    public void run() {
      System.out.println("Hello form Thread: " + getName()); //Thread - here getName() it's this (object HellThread)

    }

  }

  //Runnable approach
  public static class HelloThreadRunnable implements Runnable {

    @Override
    public void run() {
      System.out.println("Hello form Runnable: " + Thread.currentThread().getName());  //Runnable - here getName() we use class Thread
    }
  }

}
