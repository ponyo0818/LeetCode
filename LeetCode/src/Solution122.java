/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 *
 * ! This is a similar question with 121, see explanation there
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int diff[] = new int[prices.length-1];
        for(int i=1; i<prices.length; i++){
            diff[i-1] = prices[i] - prices[i-1];
        }
        return maxSubArray(diff);
    }
    public int maxSubArray(int[] nums) {
        if(nums.length<1) return 0;
        int total = 0;
        //*maxCur = current maximum value
        //*maxSoFar = maximum value found so far
        for(int i=0; i<nums.length; i++){
            if (nums[i]>0)
            total+=nums[i];
        }
        return total;
    }
    public static void main(String [] args){
        Solution122 ns = new Solution122();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(ns.maxProfit(prices));
    }
}
