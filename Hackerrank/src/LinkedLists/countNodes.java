package LinkedLists;

public class countNodes {
    int count=1;

    int count(ListNode head){
        ListNode current = head;

        while (current.next != null){
            current = current.next;
            count++;
        }
        return count;
    }
}
