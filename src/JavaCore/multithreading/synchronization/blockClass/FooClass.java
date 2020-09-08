package JavaCore.multithreading.synchronization.blockClass;

//The code in object level lock, only Foo.class is added in synchronized block.
// All the threads are getting created using object of Foo class will get blocked.
//Synchronized block is going to be executed for the same thread.

public class FooClass implements Runnable{
    @Override
    public void run() {
        lock();
    }

    public void lock() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName);
        synchronized(FooClass.class) {
            System.out.println(threadName + " inside block " );
        }
    }

    public static void main(String[] args) {
        FooClass b1 = new FooClass();
        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b1);
        FooClass b2 = new FooClass();
        Thread t3 = new Thread(b2);
        t1.setName("thread_t1");
        t2.setName("thread_t2");
        t3.setName("thread_t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
