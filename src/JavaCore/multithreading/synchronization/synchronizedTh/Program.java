package JavaCore.multithreading.synchronization.synchronizedTh;

public class Program {
    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();

        for (int i = 1; i < 5; i++){
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}

class CommonResource{
    int count = 0;
}

class CountThread implements Runnable{

    private final CommonResource resource;

    CountThread(CommonResource resource){
        this.resource = resource;
    }

    public void run(){
       synchronized (resource) {

           resource.count = 1;

            for (int i = 1; i < 5; i++) {

                System.out.printf("%s %d \n", Thread.currentThread().getName(), resource.count);

                resource.count++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

