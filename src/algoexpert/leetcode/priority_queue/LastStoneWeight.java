package algoexpert.leetcode.priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//1046. Last Stone Weight
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }

    public static int lastStoneWeight(int[] arr) {
        Queue<Integer> stones = new PriorityQueue<>(Collections.reverseOrder()); //Collections.reverseOrder()
        for (int i : arr) {
            stones.add(i);
        }

        while (stones.size() > 1){
            stones.add(stones.poll() - stones.poll());
        }

        return stones.poll();
    }
}
