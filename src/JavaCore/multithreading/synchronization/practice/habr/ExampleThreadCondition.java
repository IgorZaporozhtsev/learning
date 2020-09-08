package JavaCore.multithreading.synchronization.practice.habr;

public class ExampleThreadCondition {
/**
 * 1NEW
 * 3RUNNABLE
 * 2TERMINATED
 *
 * */
  public static void main(String[] args) {
    State thread = new State();
    System.out.println("1" + thread.getState());

    thread.start();

    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("2" + thread.getState());
  }


  public static class State extends Thread{

    @Override
    public void run() {
      System.out.println("3" + getState());
    }
  }
}
