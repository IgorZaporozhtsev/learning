package JavaCore.multithreading.synchronization.golovach._1_blocking_set;

public class BlockedSetExample {

  public static void main(String[] args) {
    BlockedSetExample ref = new BlockedSetExample();
    for (int k = 0; k < 5; k++) {
      new Thread(new BlockedMethodCaller(ref, k)).start();
    }
  }

  public synchronized void f(int x) throws InterruptedException{
    System.out.println(Thread.currentThread().getName() + " +" + x);
    Thread.sleep(1500);
    System.out.println(Thread.currentThread().getName() + " -" + x);
    Thread.sleep(1500);
  }
}
