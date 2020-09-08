package JavaCore.multithreading.synchronization.golovach._3_buffer;

public class Consumer implements Runnable {
  private final SingleElementBuffer buffer;

  public Consumer(SingleElementBuffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    while (true){
      try {
        int elem = buffer.get();
        System.out.println(elem + " consumed");
      } catch (InterruptedException e){
        System.out.println(Thread.currentThread().getName());
        return;
      }
    }
  }
}
