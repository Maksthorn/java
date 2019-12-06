package LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicatesInLinkedList {
    void removeDups(ListNode node){
        HashSet set = new HashSet<Integer>();
        ListNode previous = null;

        while(node != null){
            if(set.contains(node.val)){
                previous.next = node.next;
            }else{
                set.add(node.val);
                previous = node;
            }
            //node = node.next;
        }

    }
    class ListNode {
        int val;
        LinkedLists.ListNode next;
        ListNode(int x) { val = x; }
    }
}
