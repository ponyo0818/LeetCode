import java.util.Stack;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class Solution101 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }

    /**
     * 1. Recursive approach
     * Time complexity : O(n).
     * Space complexity : O(n)
     */
    public boolean isSymmetric1(TreeNode root){
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2==null) return true;
        if(t1 == null || t2 ==null) return false;
        return (t1.val==t2.val) & isMirror(t1.left,t1.right)&&isMirror(t1.right,t2.left);
    }

    /**
     * 2. Iterative approach
     * using stack, push the node by the order of n1.left->n2.right->n1.right->n2.left
     * Time complexity : O(n).
     * Space complexity : O(n).
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;//The continue statement breaks one iteration (in the loop)
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

    public static void main(String[] args){
        Solution101 ns = new Solution101();
        TreeNode root= new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(ns.isSymmetric1(root));
    }

}
