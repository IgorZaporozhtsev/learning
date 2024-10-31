package JavaCore.multithreading.thread_comunication.javalinUa;

public class IntegerManger {

    private Integer value = null;

    public synchronized int getValue(){
        System.out.println("Trying to get a value ....");

        if (value == null){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Returned value is " + value);
        return value;
    }

    public synchronized void setValue(int value){
        System.out.println("Inserted new value " + value);
        this.value = value;
        System.out.println("Value is placed");
        notify();
    }
}
