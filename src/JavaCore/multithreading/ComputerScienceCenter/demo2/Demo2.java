package JavaCore.multithreading.ComputerScienceCenter.demo2;

/**
 * Example how interrupt threads
 *
 */
public class Demo2 {

  public static void main(String[] args) throws Exception{
    Thread worker = new WorkerThread();
    Thread sleeper = new SleeperThread();

    System.out.println("Starting Threads");

    worker.start();
    sleeper.start();

    Thread.sleep(100L);

    // interrupt() - thread don't interrupting immediately
    System.out.println("Interrupting threads");
    worker.interrupt();
    sleeper.interrupt();

    System.out.println("Joining threads");
    worker.join(); //Main thread wait (go sleep) while thread worker will be finish
    sleeper.join(); //Main thread wait (go sleep) while thread sleeper will be finish

    System.out.println("All done");

  }

  public static class WorkerThread extends Thread{

    @Override
    public void run() {
      long sum = 0;
      for (int i = 0; i < 1_000_000_000; ++i) {
        sum += i;
        if (i % 100 == 0 && isInterrupted()){
          System.out.println("Worker loop interrupted at i = " + i);
          break;
        }
      }
    }
  }

  public static class SleeperThread extends Thread{

    @Override
    public void run() {
      try{
        Thread.sleep(10000L); //thread interruption point
      } catch (InterruptedException e){
        System.out.println("Sleep interrupted");
      }
    }
  }
}
