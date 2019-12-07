package LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicatesInLinkedList {
    void removeDups(ListNode node){
        HashSet set = new HashSet<Integer>();
        ListNode previous = null;

        while(node != null){
            if(set.contains(node.data)){
                previous.next = node.next;
            }else{
                set.add(node.data);
                previous = node;
            }
            node = node.next;
        }

    }

}
