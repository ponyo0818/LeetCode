
import java.util.ArrayList;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *  !BST-balanced search tree
 *  1. left subtree of a node contains only nodes with value < it's values
 *  2. right subtree of a node contains only nodes with value > it's values
 *  3. The left and right subtree each must also be a BST. There must be no duplicate nodes.
 */


public class Solution108 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }

    /**
     * Recursive approach
     * runtime complexity: O(n)
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums){
        if (nums.length==0) return null;
        TreeNode root = helper(nums, 0, nums.length-1);
        return root;
    }
    public TreeNode helper (int[]nums, int low, int high){
        if(low>high) return null;
        int mid = low + (high-low)/2;//instead of mid=(low+high)/2 to avoid integer overflow
        TreeNode node = new TreeNode(nums[mid]);//set the current node
        node.left = helper(nums, low, mid-1); //left part is always less than
        node.right = helper(nums, mid+1, high); //right part
        return node;
    }
    public static void main(String[]args) {
        Solution108 ns = new Solution108();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = ns.sortedArrayToBST(nums);
        ArrayList<Integer> ary = new ArrayList<>();
        ns.printTree(root);
    }

    public void printTree(TreeNode root) {
            if (root == null) return;
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
    }

}
