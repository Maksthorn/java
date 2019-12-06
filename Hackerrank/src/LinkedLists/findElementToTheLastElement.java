package LinkedLists;

public class findElementToTheLastElement {
    int findElementToTheLastElement(ListNode head, int k){
        if(head == null){
            return 0;
        }

        int index = findElementToTheLastElement(head.next, k) + 1;
        if(index == k){
            System.out.println(k +"th to the last node is " + head.val);
        }
        return index;
    }
}
