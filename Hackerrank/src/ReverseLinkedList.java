public class ReverseLinkedList {
    
      public class ListNode {
          int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode reverseList(ListNode head1) {
            ListNode prev = null;
            ListNode cur = head1;

            while(cur != null){
                ListNode tmp = cur.next;
                cur.next= prev;
                prev = cur;
                cur = tmp;

            }

            return prev;

        }
    }
}
