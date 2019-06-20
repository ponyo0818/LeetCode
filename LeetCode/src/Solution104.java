import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class Solution104 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }

    /**
     * 1. recursive approach
     * if the node does not exist, simply return 0. Otherwise, return the 1+the longer distance of its subtree.
     * Time complexity: O(n) for the n nodes
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        int leftMax = root.left == null ? 0 : maxDepth(root.left);
        int rightMax = root.right == null ? 0 : maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);//A node has depth 1 if it is not null, otherwise depth 0.
    }

    /**
     * Iterative
     * O(n) time complexity. O(logn) space complexity
     * 2. DFS Approach use two stacks
     * @param root
     * @return
     */
    public int maxDepthDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();//a stack hold the node
        Stack<Integer> value = new Stack<>(); //a stack hold the depth
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max); //keep the max depth
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }

    /**
     * BFS approach using a queue for the level-order traversal FASTER
     * it counts each level once. for example this part of the code gets rid of the
     * nodes which are on the same level by popping them after adding +1 to height
     * O(n) time complexity. O(n) space complexity
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size(); //the size of the current layer
            while(size-- > 0) {//the inner loop is for each layer, the same as for (int i=0, i<=size, i++)
                TreeNode node = queue.poll();//return and remove the 1st element
                //offer(add) all the child of the node in the current layer to the queue,
                // meanwhile remove the node in the current layer
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

}
