import java.util.ArrayList;
import java.util.Arrays;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
 * nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Solution21 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * 1. Dummy Node Approach
     * @param l1
     * @param l2
     * @return
     *
     * e.g.
     * l1- 1, 3, 5
     * l2- 1, 2, 4
     *
     * l1.val (1) == l2.val(1)-> dummy-1, l2= 2, tail =1
     * l1.val (2) > l2.val (1) -> dummy-1-1, l1 =3, tail = 1(the second one)
     */
    public ListNode mergeTwoListsDN(ListNode l1, ListNode l2){
        //create a dummy node to hang the result on (put it at the most front of the linkedList)
        ListNode dummyNode = new ListNode(0);
        //tail points to the current ListNode
        ListNode tail = dummyNode;

        while(true){
            if (l1 == null) {
                tail.next = l2;
                break;
            }
            if (l2 == null) {
                tail.next = l1;
                break;
            }
            //if current l2 smaller than current l1, point the current to the current l2, advance current l2
            if (l2.val <= l1.val ){
                tail.next = l2;
                l2 = l2.next;
            }
            //otherwise, point the current to current l1, advance current l1
            else{
                tail.next = l1;
                l1 = l1.next;
            }
            //advance the tail, because we just added 1 Node to the tail
            tail = tail.next;
        }
        return dummyNode.next;
    }

    /**
     * Recursion
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsR(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        /**Always point to the node which is smaller
        */
        if(l1.val < l2.val){
            l1.next = mergeTwoListsR(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListsR(l1, l2.next);
            return l2;
        }
    }

    public static void main (String [] args){
        Solution21 linkedList1 = new Solution21();
        Solution21 linkedList2 = new Solution21();


        Solution21.ListNode firstl1 = new Solution21.ListNode(1);
        Solution21.ListNode secondl1 = new Solution21.ListNode(3);
        Solution21.ListNode thirdl1 = new Solution21.ListNode(5);

        Solution21.ListNode firstl2 = new Solution21.ListNode(1);
        Solution21.ListNode secondl2 = new Solution21.ListNode(2);
        Solution21.ListNode thirdl2 = new Solution21.ListNode(4);

        firstl1.next = secondl1;
        secondl1.next = thirdl1;

        firstl2.next = secondl2;
        secondl2.next = thirdl2;


        Solution21.ListNode result = linkedList1.mergeTwoListsDN(firstl1, firstl2);
        Solution21.ListNode current = result; //head
        //Create an ArrayList to store the values
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (current!=null){
            //System.out.println (current.val);
            list.add(current.val);
            current = current.next;
        }
        //*the way to print an ArrayList
        System.out.println(Arrays.toString(list.toArray()));
    }
}
