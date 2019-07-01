import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 * Recursion in this case will take more than constant extra space, so select an iterative method
 */
public class Solution116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * Iterative approach
     * starting from the right most side
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node next = null;
            for(int i = 0; i < size; i++) {
                Node curr = queue.poll(); //curr node is pop from the queue
                curr.next = next; //curr node's next is the one poped in the last loop
                next = curr; //store the curr as the next of the next left node
                if(curr.right != null)
                    queue.offer(curr.right); //add the right at first
                if(curr.left != null)
                    queue.offer(curr.left);
            }
        }
        return root;
    }
}
