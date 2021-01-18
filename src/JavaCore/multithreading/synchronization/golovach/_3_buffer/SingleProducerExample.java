package JavaCore.multithreading.synchronization.golovach._3_buffer;

public class SingleProducerExample {

  public static void main(String[] args) {
    SingleElementBuffer buffer = new SingleElementBuffer();
    new Thread(new Producer(1, 1800, buffer)).start();
    new Thread(new Consumer(buffer)).start();
  }

}

class Producer implements Runnable {
  private final int period;
  private final SingleElementBuffer buffer;
  private int startValue;

  public Producer(int startValue, int period,
                  SingleElementBuffer buffer) {
    this.startValue = startValue;
    this.period = period;
    this.buffer = buffer;
  }

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println(startValue + " produced");
        buffer.put(startValue++);
        Thread.sleep(period);
      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName());
        return;
      }
    }
  }
}


class Consumer implements Runnable {
  private final SingleElementBuffer buffer;

  public Consumer(SingleElementBuffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    while (true) {
      try {
        int elem = buffer.get();
        System.out.println(elem + " consumed");
      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName());
        return;
      }
    }
  }
}

class SingleElementBuffer {
  private Integer elem = null;

  public synchronized void put(Integer newElem) throws InterruptedException {
    while (elem != null) {
      this.wait();
    }
    this.elem = newElem;
    this.notifyAll();
  }

  public synchronized Integer get() throws InterruptedException {
    while (elem == null) {
      this.wait();
    }
    int result = this.elem;
    this.elem = null;
    this.notifyAll();
    return result;
  }

}
