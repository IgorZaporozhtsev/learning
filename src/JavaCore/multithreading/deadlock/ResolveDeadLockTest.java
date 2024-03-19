package JavaCore.multithreading.deadlock;

public class ResolveDeadLockTest {

    public static void main(String[] args) {
        ResolveDeadLockTest test = new ResolveDeadLockTest();

        final A a = test.new A();
        final B b = test.new B();


        // Thread-1 //меняеи местами a и b и у нас deadlock
       Runnable block1 = () -> {
           synchronized (b) {
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               // Thread-1 заняла A но также нуждается в B
               synchronized (a) {
                   System.out.println("In block 1");
               }
           }
       };

       // Thread-2
       Runnable block2 = () -> {
           synchronized (b) {
               // Thread-2 заняла B но также нуждается в A
               synchronized (a) {
                   System.out.println("In block 2");
               }
           }
       };

        new Thread(block1).start();
        new Thread(block2).start();

    }


    // Resource A
    class A {
        private int i = 10;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    // Resource B
    class B {
        private int i = 20;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

}