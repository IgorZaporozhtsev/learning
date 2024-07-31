package bobocode.online_traning_1_task_1;

import java.util.ArrayList;
import java.util.List;

public class DemoCauseError {
    public static void main(String[] args) {
        //cause StackOverflowException
        //recurtion();
        //maxArrIntegers();
        heapObject();

    }

    private static void recurtion() {
        recurtion();
    }

    private static void maxArrIntegers() {
        int[] arr = new int[1_999_999_999];

    }

    private static void heapObject() {
        List<Object> list = new ArrayList<>();
        while (true){
            list.add(new Object());
        }

    }

}
