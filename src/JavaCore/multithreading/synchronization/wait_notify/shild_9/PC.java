package JavaCore.multithreading.synchronization.wait_notify.shild_9;

public class PC {
    public static void main (String args[]) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Для остановки нажте Ctrl-C . ");
    }

    public static class Q {
        int n;
        //boolean

        synchronized int get ( ) {
            System.out.println("Пoлyчeнo : " + n);
            return n;
        }

        synchronized void put(int n){
            this.n = n;
            System.out.println(" Oтпpaвлeнo : " + n);
        }
    }

    public static class Consumer implements Runnable{
        Q q ;

        Consumer(Q q){
            this.q = q;
            new Thread(this, " Потребитель ").start();
        }

        @Override
        public void run() {
            while (true) {
                q.get();
            }
        }
    }

    public static class Producer implements Runnable{
        Q q;

        Producer(Q q) {
            this.q = q;
            new Thread(this, "Поставщик").start();
        }

        @Override
        public void run() {
            int i = 0;
            while (true){
                q.put(i++);
            }
        }
    }

}
