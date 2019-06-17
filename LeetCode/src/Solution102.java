import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * ---------------------------------
 * 1. Why use linkedlist in ArrayList
 * Insertions are easy and fast in LinkedList as compared to ArrayList because there is no
 * risk of resizing array and copying content to new array if array gets full which makes
 * adding into ArrayList of O(n) in worst case, while adding is O(1) operation in LinkedList
 * in Java. ArrayList also needs to be update its index if you insert something anywhere except
 * at the end of array.
 *
 * 2. Queue offer()
 * inserts the specified element into this queue if it is possible to do so immediately without
 * violating capacity restrictions.
 */
public class Solution102 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }

    /**
     * DFS Approach
     *  it implements pre-order traversal to realize level-order traversal. Each time we add root.val into the list,
     *  and then look at left and right child.
     *
     *  Time complexity: O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();//create a 2 dimensional list
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        //add a LinkedList for nodes at a certain "height" (level) to the result ArrayList
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val); //add root.val to res at index(height)
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

    /**
     * BFS Approach
     * Time complexity: O(n)
     * 1. Add nodes in each height to the queue.
     * 2. Add nodes from the queue to the result list, meanwhile remove it from the queue.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if(root == null) return res;

        queue.offer(root);//insert root to the queue
        while(!queue.isEmpty()){
            int height = queue.size();//get the number of nodes in each height, which decide the number of loop later
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<height; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);//peek() only return the first
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);//return and remove the first
            }
            res.add(subList);
        }
        return res;
    }

    public static void main(String[] args){
        Solution102 ns = new Solution102();
        TreeNode root= new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(ns.levelOrderBFS(root));
    }
}
