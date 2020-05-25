package JavaCore.multithreading.synchronization.golovach._3_buffer;

public class Producer implements Runnable {
  private int startValue;
  private final int period;
  private final SingleElementBuffer buffer;

  public Producer(int startValue, int period,
      SingleElementBuffer buffer) {
    this.startValue = startValue;
    this.period = period;
    this.buffer = buffer;
  }

  @Override
  public void run() {
    while (true){
      try {
        System.out.println(startValue + " produced");
        buffer.put(startValue++);
        Thread.sleep(period);
      } catch (InterruptedException e){
        System.out.println(Thread.currentThread().getName());
        return;
      }
    }
  }
}
