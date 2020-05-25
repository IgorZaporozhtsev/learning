package JavaCore.multithreading.synchronization.golovach._3_buffer;

public class SingleProducerExample {

  public static void main(String[] args) {
    SingleElementBuffer buffer = new SingleElementBuffer();
    new Thread(new Producer(1, 1800, buffer)).start();
    new Thread(new Consumer(buffer)).start();
  }

}
