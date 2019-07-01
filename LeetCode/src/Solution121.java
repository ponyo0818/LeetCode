/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * ay you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 * -----------------------
 * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm.
 * Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array,
 * and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
 */
public class Solution121 {
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
        int maxCur = 0, maxSoFar = 0;
        //*maxCur = current maximum value
        //*maxSoFar = maximum value found so far
        for(int i=0; i<nums.length; i++){
            maxSoFar = Math.max(maxSoFar, maxCur+nums[i]);
            //once maxCur is <0, means that we can't get any profit, set to 0 and restart to calculate the maxCur
            //for example: (7, 1, 5, 3, 6, 4) ->ary[i]-[i-1] :(-6, 4, -2, 3, -2), find the max sum subarray to get the highest profit
            maxCur = Math.max(0, maxCur+nums[i]);
        }
        return maxSoFar;
    }

    public static void main(String [] args){
        Solution121 ns = new Solution121();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(ns.maxProfit(prices));
    }
}
