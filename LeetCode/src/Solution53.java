/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Dynamic Programming approach
 * To calculate sum(0,i), you have 2 choices: either adding sum(0,i-1) to a[i], or not. If sum(0,i-1) is negative,
 * adding it to a[i] will only make a smaller sum, so we add only if it's non-negative.
 *
 * sum(0,i) = nums[i] + (sum(0,i-1) < 0 ? 0 : sum(0,i-1))
 *
 * Time complexity O(n)
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);//add the previous sum (dp[i-1])only if it is positive
            max = Math.max(max, dp[i]); //update the max sum
        }
        return max;
    }

    public static void main(String[] args){
        Solution53 ns = new Solution53();
        int [] nums = new int[] {1,2,3,-5,6,-7,5};
        System.out.println(ns.maxSubArray(nums));
    }
}
