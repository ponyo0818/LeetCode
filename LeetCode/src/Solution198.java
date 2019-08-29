/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 *
 */
public class Solution198 {
    /**
     * Iterative approach using two variables (bottom-up)
     * Time complexity O(n)
     * Explanation:
     * 1. two situation : rub the current one or not.
     * 2. Two variable, [prev1] record the maximum value you can get WITHOUT rob the current
     *  [prev2] record the maximum value you can get WITH rob the current
     * 3. Use the temp to store the maximum value
     * @param nums
     * @return
     */
    public int rob(int[] nums){
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums){
            int temp = prev1;
            prev1 = Math.max ((prev2 + num), prev1); //the max value you can rob
            prev2 = temp;
        }
        return prev1;
    }

    public static void main (String [] args){
        Solution198 ns = new Solution198();
        int [] nums = new int[]{2,1,1,3};
        System.out.println (ns.rob (nums));
     }
}
