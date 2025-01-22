package algoexpert.leetcode.stack;

public class MinStack {

    Node head;

    public MinStack() {

    }

    public void push(int val) {
        Node current = head;
        if (head == null){
            head = new Node(val);
        }else {
            Node node = new Node(val);
            node.next = current;
            head = node;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        Node current = head;
        int sum = current.value;
        while (current != null){
            sum = Math.min(current.value, sum);
            current = current.next;
        }
        return sum;
    }

    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
