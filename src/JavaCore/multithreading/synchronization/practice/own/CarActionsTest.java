package JavaCore.multithreading.synchronization.practice.own;

public class CarActionsTest {

  public static void main(String[] args) {
    CarActionsTest actions = new CarActionsTest();
    for (int k = 0; k < 10; k++) {
      new Thread(new DoActions(actions, k)).start();
    }
  }

  public synchronized void checkMirror(int stateDore) throws InterruptedException {
      System.out.println("door open " +  stateDore);
      Thread.sleep(1000);
      System.out.println("door closed " +  stateDore);
  }
}
