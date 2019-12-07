import LinkedLists.ReverseLinkedList;

import java.util.Arrays;

public class Test {
    public static void main(String args[]){
        int ar[] = {1,2,4,5,6,7};

        System.out.println(Arrays.toString(arrayTest(ar)));

    }


    static int[] arrayTest(int []ar){
//        for (int a: ar) {
//            System.out.println(a);
//        }
        ar[0] = 10;
        return ar;
    }

    public class ListNode {
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
        }
    }
}
