package algoexpert.leetcode.stack.implement_stack;

public class MyStack {
    //https://leetcode.com/problems/implement-stack-using-queues/description/
    //225. Implement Stack using Queues
    Node head;
    int size = 0;

    public MyStack() {
    }

    public void push(int i) {
        Node newNode = new Node(i);
        if (head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public int pop() {
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public int top() {
        return head.value;
    }

    public boolean empty() {
        return size == 0;
    }

    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
