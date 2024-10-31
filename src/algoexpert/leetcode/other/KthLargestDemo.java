package algoexpert.leetcode.other;

import java.util.PriorityQueue;

public class KthLargestDemo {
    public static void main(String[] args) {
        int[] arr = {4,5,8,2};
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

    public KthLargest(int k, int[] a) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (queue.size() < k)
            queue.offer(n); //add
        else if (queue.peek() < n) {
            queue.poll();       //retrive
            queue.offer(n);  //add
        }
        return queue.peek();
    }
}