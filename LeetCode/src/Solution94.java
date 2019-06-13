import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3] preorder
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2] inorder
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class Solution94 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Approach 1: Recursive Approach
     * The first method to solve this problem is using recursion. This is the classical method and is
     * straightforward. We can define a helper function to implement recursion.
     * Time complexity : O(n)
     * Space complexity : The worst case space required is O(n), and in the average case it's O(logn) where nn is number of nodes.
     * @param root
     * @return
     */
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }
    //the function add the value of root to the list, at the order of left to root to right
    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val); //at the left the node at the lowest level
            //if there are no left can go, go right
            if (root.right != null) {
                helper(root.right, res);//check the left node again in the next recursion, if not left one, add the right one
            }
        }
    }

    /**
     * Approach 2: Iterating method using Stack
     * Time complexity : O(n).
     * Space complexity : O(n).
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            //keep adding left to the stack, the last one is on the top of the stack
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();//where the cur.right is null, cur=stack.pop() which is the root of previous one
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
    /**
     * Approach 3:
     * Morris Traversal
     * In this method, we have to use a new data structure-Threaded Binary Tree
     * 二叉树添加了直接指向节点的前驱和后继的指针的二叉树称为线索二叉树
     */

    public static void main(String[] args){
        Solution94 ns = new Solution94();
        TreeNode root= new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(ns.inorderTraversal(root));
    }
}
