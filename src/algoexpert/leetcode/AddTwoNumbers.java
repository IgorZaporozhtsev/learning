package algoexpert.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = getListNode(2, 4, 3);
        ListNode l2 = getListNode(5, 6, 4);


        System.out.println(addTwoNumbers(l1, l2));

    }

    private static ListNode getListNode(int val, int val1, int val2) {
        var l2 = new ListNode(val);
        var l22 = new ListNode(val1);
        var l222 = new ListNode(val2);
        l2.next = l22;
        l22.next = l222;
        return l2;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = null;
        int sum = 0;
        int remember = 1;

        do {
            sum = l1.val + l2.val;

            if (result == null) {
                result = new ListNode(sum);
                head = result;
            } else {
                if (sum == 10) {
                    result.next = new ListNode(0);

                } else {
                    result.next = new ListNode(sum + remember);
                }
                result = result.next;
            }


            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null);


        return head;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


}
