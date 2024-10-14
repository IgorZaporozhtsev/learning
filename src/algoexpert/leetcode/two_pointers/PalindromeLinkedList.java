package algoexpert.leetcode.two_pointers;

public class PalindromeLinkedList {
    //234. Palindrome Linked List
    //fast-slow pointer
    public static void main(String[] args) {
        var head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(3,
                                        new ListNode(4,
                                            new ListNode(4,
                                                    new ListNode(3,
                                                            new ListNode(2 ,
                                                                    new ListNode(1)))))))));
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //find middle
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse second half
        ListNode prev = null;
        while (slow != null){
            ListNode tmp = slow.next;
            slow.next =prev;
            prev = slow;
            slow = tmp;
        }

        ListNode left = head;
        ListNode right = prev;

        while (right != null){
            if (left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
          this.val = val; this.next = next;
      }

}
