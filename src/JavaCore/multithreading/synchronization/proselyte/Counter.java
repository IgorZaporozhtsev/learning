package JavaCore.multithreading.synchronization.proselyte;

public class Counter {
  public synchronized void displayCounter(){
    try {
      for(int i = 1; i<=5; i++){
        System.out.println("Counter: " + i);
      }
    }catch (Exception e){
      System.out.println("Thread is interrupted.");
    }
  }
}
