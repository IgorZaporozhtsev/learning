package algoexpert.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = getListNode(2, 4, 3, 4);
        ListNode l2 = getListNode(5, 6, 4);


        System.out.println(addTwoNumbers(l1, l2));

    }

    private static ListNode getListNode(int val, int val1, int val2, int val3) {
        var l2 = new ListNode(val);
        var l22 = new ListNode(val1);
        var l222 = new ListNode(val2);
        var l2222 = new ListNode(val3);
        l2.next = l22;
        l22.next = l222;
        l222.next = l2222;
        return l2;
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
        return sum(l1, l2, new ListNode());
    }

    private static ListNode sum(ListNode l1, ListNode l2, ListNode result) {
        if (l2 == null) {
            return result;
        }
        var sum = l1.val + l2.val;
        if (result.val == 0) {
            result = new ListNode(sum);
        } else {
            result.next = new ListNode(sum);


        }
        return sum(l1.next, l2.next, result);
    }

/*
*  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = null;
        int sum = 0;
        int remember = 1;

        do {
            sum = l1.val + l2.val;

            if (result == null){
                result = new ListNode(sum);
                head = result;
            } else {
                if (sum == 10){
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
*
* */

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
