package JavaCore.multithreading.synchronization.golovach._1_blocking_set;

public class BlockedMethodCaller implements Runnable {

  BlockedSetExample ref;
  int k;

  public BlockedMethodCaller(BlockedSetExample ref, int k) {
    this.ref = ref;
    this.k = k;
  }


  @Override
  public void run() {
    try {
      ref.f(k);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
