import java.util.ArrayList;
import java.util.Arrays;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class Solution19 {
     ListNode head;
     static class ListNode{
        //create class attributes
        int val;
        ListNode next;
        //constructor which can take parameters
        ListNode (int x) {val = x;}
    }

    /**
     * Two pass algorithm
     * Time complexity : O(L)
     *
     * The algorithm makes two traversal of the list, first to calculate list length LL and second to find the (L - n)th node.
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //add an "dummy" node which points to the list head.
        //"dummy" node is used to simplify some corner cases such as a list with only one node,
        // or removing the head of the list.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        //get the length of the LinkedList [First Pass]
        while (first != null) {
            length++;
            first = first.next;
        }
        //get the index of the n-th node from the end of list (L-n)
        length -= n;
        first = dummy;
        //we set a pointer to the dummy node and start to move it through the list till it comes
        // to the (L - n) th node.
        while (length > 0) {
            length--;
            first = first.next;
        }
        // relink next pointer of the (L - n) th node to the (L - n + 2) th node
        first.next = first.next.next;
        return dummy.next; //return the head which is a part of the modified LinkedList
    }

    /**
     * Approach 2: One pass algorithm
     * Time complexity : O(L)
     *
     * The algorithm makes one traversal of the list of LL nodes. Therefore time complexity is O(L).
     * Instead of one pointer, we could use two pointers. The first pointer advances the list by n+1 steps from the
     * beginning, while the second pointer starts from the beginning of the list. Now, both pointers are exactly
     * separated by nn nodes apart. We maintain this constant gap by advancing both pointers together until the first
     * pointer arrives past the last node. The second pointer will be pointing at the nth node counting from the last.
     * We relink the next pointer of the node referenced by the second pointer to point to the node's next next node.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap which is n
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static void main (String [] args){
        Solution19 linkedList = new Solution19();
        linkedList.head = new ListNode(1);
        ListNode second = new ListNode (2);
        ListNode third = new ListNode (3);
        ListNode fourth = new ListNode (4);
        ListNode fifth = new ListNode (5);
        linkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        ListNode result = linkedList.removeNthFromEnd1(linkedList.head,2);
        ListNode current = result; //head
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
