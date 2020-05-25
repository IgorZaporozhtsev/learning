package JavaCore.multithreading.synchronization.blockObject;

//Обратите внимание, что t3 не будет блокироваться при блокировании потоков t1 и t2.
// Поскольку блокировка помещается на этот объект, а поток t3 имеет другой объект, чем поток t1, t2

public class FooObject implements Runnable{
    @Override
    public void run() {
        Lock();
    }

    public void Lock() {
        System.out.println(Thread.currentThread().getName());
        synchronized(this) {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    public static void main(String[] args) {
        FooObject b1 = new FooObject();
        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b1);
        FooObject b2 = new FooObject();
        Thread t3 = new Thread(b2);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
