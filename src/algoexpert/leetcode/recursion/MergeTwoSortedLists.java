package algoexpert.leetcode.recursion;

public class MergeTwoSortedLists {
    //21. Merge Two Sorted Lists
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(node1, node2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null){
           if (list1.val < list2.val){
               tail.next = list1;
               list1 = list1.next;
           } else {
               tail.next = list2;
               list2 = list2.next;
           }
           tail = tail.next;
        }

        if (list1 != null){
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }
}


class ListNode {
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