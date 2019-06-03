/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class Solution55 {
    /**
     * Approach 1. Greedy
     * Looking from the start and selecting the locally optimum in the hope of reaching global optimum
     * Time complexity : O(n)O(n). We are doing a single pass through the nums array, hence nn steps, where nn is the length of array nums.
     * Space complexity : O(1)O(1). We are not using any extra memory.
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums){
        int n =nums.length,farest =0;
        for (int i=0; i<n; i++){
            //if the farest can not reach the current index, return false
            if (farest < i) return false;
            /**why i+ nums[i]?
             * num[i] has to be at least 1 to reach the next index
             * num[2] and num[3], if num[2]=0, i+num[i] = 2, which is <3(i),will return false
             */
            farest = Math.max(i+nums[i],farest);
        }
        return true;
    }

    /**
     * Approach 2: Backtracking
     * This is the inefficient solution where we try every single jump pattern that takes us from the first position to the last.
     * We start from the first position and jump to every index that is reachable. We repeat the process until last index is reached.
     * When stuck, backtrack.
     * Time complexity : O(2^n). There are 2^n (upper bound) ways of jumping from the first position to the last, where nn is the
     * length of array nums. For a complete proof, please refer to Appendix A.
     * Space complexity : O(n). Recursion requires additional memory for the stack frames.
     * @param position
     * @param nums
     * @return
     */
    public boolean canJumpFromPosition(int position, int[] nums) {
        //return true when reach the end
        if (position == nums.length - 1) return true;
        //update the furthestJump with the sum of position(index) and nums[position]
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        //iterate all possible move (from 1 to the furthestJump)
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) return true;
        }
        return false;
    }

    public boolean canJumpBT(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    public static void main(String[] args){
        Solution55 ns = new Solution55();
        int[] nums = new int[] {1,4,3,2,1,0,1};
        System.out.println(ns.canJump(nums));
    }
}
