package LinkedLists;

public class ReverseLinkedList {

      public class ListNode {
          int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode reverseList(ListNode head) {
            // init pointers
            ListNode previous = null;
            ListNode current = head;
            ListNode next = null;

            while(current != null){
                next = current.next; // save next
                current.next = previous; // reverse pointer only
                previous = current; // advancing pointer 'previous' to location of pointer 'current'
                current = next; // advancing pointer 'current' to location of pointer 'next'

            }

            return previous; // new head at end

        }
    }
}
