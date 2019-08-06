/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 * ----------------
 * Notice that if list A and list B have the same length, this solution will terminate in no more
 * than 1 traversal; if both lists have different lengths, this solution will terminate in no more
 * than 2 traversals -- in the second traversal, swapping a and b synchronizes a and b before the
 * end of the second traversal. By synchronizing a and b I mean both have the same remaining steps
 * in the second traversal so that it's guaranteed for them to reach the first intersection node,
 * or reach null at the same time (technically speaking, in the same iteration)
 *
 * Time complexity : O(m+n).
 *
 * Space complexity : O(1).
 */

public class Solution160 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode (ListNode headA, ListNode headB){
        //boundary check
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        //if a and b have different length, then will stop the loop after the second iteration
        while (a != b){
            //for the end of first iteration, just reset the pointer to the head of another linkedlist
            //this will help us counteract the difference of length, SO DAMN SMART!
            a = a == null? headB: a.next;
            b = b == null? headA: b.next;
        }

        return a;
    }

    public static void main(String[] args){
        Solution160 ns =new Solution160();
        ListNode node1 = new ListNode(3);
        //to be finished
    }
}
