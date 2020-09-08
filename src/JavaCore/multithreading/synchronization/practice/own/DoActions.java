package JavaCore.multithreading.synchronization.practice.own;

public class DoActions implements Runnable{

  public CarActionsTest actions;
  public int stateDore;

  public DoActions(CarActionsTest actions, int stateDore) {
    this.actions = actions;
    this.stateDore = stateDore;
  }

  @Override
  public void run() {
    try {
      actions.checkMirror(stateDore);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
