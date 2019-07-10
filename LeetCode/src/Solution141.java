import java.util.HashSet;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 */
public class Solution141 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next = null;
        }
    }

    /**
     * Time complexity: O(n), Space complexity O(n)
     * Approach 1: Hash Table
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(head!=null){
            if (!set.remove(head))set.add(head);
            else return true;
            //Or if(set.contains(head) return true; else set.add(head)
            head = head.next;
        }
        return false;
    }

    /**
     * Approach 2: Two Pointers
     * The space complexity can be reduced to O(1) by considering two pointers at different speed - a slow pointer
     * and a fast pointer. The slow pointer moves one step at a time while the fast pointer moves two steps at a time.
     * If there is no cycle in the list, the fast pointer will eventually reach the end and we can return false in this case.
     *
     * Time complexity: O(n)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
