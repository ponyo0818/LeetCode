import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 102 的followup题目！
 * key solution：加一个boolean zigzag or (height%2 ==0)
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution103 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }

    /**
     * DFS Approach
     * O(n) solution by using LinkedList along with ArrayList.
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode curr, List<List<Integer>> res, int height){
        if(curr == null) return;

        if(res.size() <= height){
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }

        List<Integer> collection  = res.get(height);
        if(height % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, res, height + 1);
        travel(curr.right, res, height + 1);
    }


    /**
     * BFS Approach
     * Time complexity: O(n)
     * 1. Add nodes in each height to the queue.
     * 2. Add nodes from the queue to the result list, meanwhile remove it from the queue.
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if(root == null) return res;

        queue.offer(root);//insert root to the queue, or queue.add(root)
        boolean zigzag =false; //add a boolean indicate reverse order
        while(!queue.isEmpty()){
            int height = queue.size();//get the number of nodes in each height, which decide the number of loop later
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<height; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);//peek() only return the first
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(zigzag) subList.add(0,queue.poll().val);
                else subList.add(queue.poll().val);//return and remove the first
            }
            res.add(subList);
            zigzag =!zigzag;
        }
        return res;
    }

    public static void main(String[] args){
        Solution103 ns = new Solution103();
        TreeNode root= new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(7);
        System.out.println(ns.zigzagLevelOrderBFS(root));
    }

}
