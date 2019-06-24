/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7] (root, left, right)
 * inorder = [9,3,15,20,7] (left, root, right)
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  Key solution idea:
 *  say we have two arrays: PRE and IN
 *  preorder traversing implies that PRE[0] is the root node, then find this in IN, say IN[5]
 *  then we can tell IN[0] - IN[4] are on the left, IN[5]-IN[end] are on the right
 *
 *  Recursively doing this on subarrays, we can build a tree out of it
 *  helper(int preStart, int inStart, int inEnd, int[] preorder, int[]inorder)
 *  preStart for the left part: preStart+1
 *           for the right part: preStart +1 + (inIndex - inStart) this is how many items on the left
 *
 *  ###One improvement: remember to use HashMap to cache the inorder[] position.
 *
 *
 */
public class Solution105 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]); //tree root is the start in PRE array
        int inIndex = 0; // Index of current root in inorder
        //get the index in IN which the root is located
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main (String[]args){
        Solution105 ns =new Solution105();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        ns.buildTree(preorder,inorder);
    }
}
