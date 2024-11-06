package algoexpert.leetcode.priority_queue;

import java.util.PriorityQueue;

public class KthLargestDemo {
    public static void main(String[] args) {
        //int[] arr = {4,5,8,2};
        int[] arr = {2,4,5,8};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
    }
}


class KthLargest {
    final PriorityQueue<Integer> queue;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        if (queue.size() < k)
            queue.offer(val); //add
        else if (queue.peek() < val) {
            queue.poll();       //Retrieves and removes the head of this queue
            queue.offer(val);  //add
        }
        return queue.peek(); //Retrieves, but does not remove
    }
}