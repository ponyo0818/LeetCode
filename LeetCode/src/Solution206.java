import java.util.ArrayList;
import java.util.Arrays;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */

public class Solution206 {
    //Definition for singly-linked list.
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
        /**
         * Iterative Approach
         * Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n).
         *
         * Space complexity : O(1).
         * @param head
         * @return
         */
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * Recursive approach
     * the key is to work backwards. Assume that the rest of the list had already been reversed, now how do I reverse the front part?
     * Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n)
     *
     * Space complexity : O(n). The extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.
     *
     * 1->2->3->4->5->null
     *             |
     *           return this and null.next=5, 5.next=null
     * 1->2->3->4->5<-null
     *          |
     *          return this and 5.next=4, 4.next =null
     *
     * @param head
     * @return
     */
    public ListNode reverseListR(ListNode head) {
        //Whenever the current(head).next is equal to null, return this node
        if (head == null || head.next == null) return head;
        ListNode p = reverseListR(head.next);//will work backwards
        head.next.next = head;
        head.next = null;//always set the current(head).next to null
        return p;
    }

    public static void main(String[] args){
        Solution206 ns = new Solution206();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode (2);
        ListNode third = new ListNode (3);
        ListNode fourth = new ListNode (4);
        ListNode fifth = new ListNode (5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        ListNode result = ns.reverseList(head);
        ListNode current =result;
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
