package bobocode.online_traning_1_task_0;

import java.util.Comparator;
import java.util.List;

public class DemoFindMin {
    public static void main(String[] args) {
        List<Integer> nums = List.of(84, 323, 323, 4322, 943, 123, 72);
        System.out.println(findMinValue(nums));

    }

    static int findMinValue(List<Integer> nums) {
        return nums.stream()
                .min(Comparator.comparing(num -> num.intValue()))
                .orElseThrow();
    }
}
