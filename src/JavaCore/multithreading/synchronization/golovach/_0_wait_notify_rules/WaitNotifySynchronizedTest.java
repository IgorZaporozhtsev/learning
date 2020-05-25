package JavaCore.multithreading.synchronization.golovach._0_wait_notify_rules;

public class WaitNotifySynchronizedTest {

  public static void main(String[] args) {
    f();
  }

  private static synchronized void f() {
    Class clazz = WaitNotifySynchronizedTest.class;
    clazz.notify();
  }

}
