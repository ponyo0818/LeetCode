import java.util.*;

/**
 * 234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 *
 *
 * In the beginning, set two pointers fast and slow starting at the head.
 *
 * 1 -> 1 -> 2 -> 1 -> null
 * sf
 * (1) Move: fast pointer goes to the end, and slow goes to the middle.
 *
 * 1 -> 1 -> 2 -> 1 -> null
 *           s          f
 * (2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
 *
 * 1 -> 1    null <- 2 <- 1
 * h                      s
 * (3) Compare: run the two pointers head and slow together and compare.
 *
 * 1 -> 1    null <- 2 <- 1
 *      h            s
 */
public class Solution234 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
        }
    }
    public boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        while(slow != null && head.val == slow.val){
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next =prev;
            prev = head;
            head = next;
        }
        return prev;
    }


}
