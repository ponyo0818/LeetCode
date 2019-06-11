import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 *
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * -------------------------------------
 * All backtracking problems are composed by these three steps: choose, explore, unchoose.
 * So for each problem, you need to know:
 *
 * choose what? For this problem, we choose each substring.
 * how to explore? For this problem, we do the same thing to the remained string.
 * unchoose? Do the opposite operation of choose.
 * Let's take this problem as an example:
 * 1.Define helper(): Usually we need a helper function in backtracking problem, to accept more parameters.
 * 2.Parameters: Usually we need the following parameters
 *
 *     1. The object you are working on:  For this problem is String s.
 *     2. A start index or an end index which indicate which part you are working on: For this problem, we use substring
 *     to indicate the start index.
 *     3. A step result, to remember current choose and then do unchoose : For this problem, we use List<String> step.
 *     4. A final result, to remember the final result. Usually when we add, we use 'result.add(new ArrayList<>(step))'
 *     instead of 'result.add(step)', since step is reference passed. We will modify step later, so we need to copy it
 *     and add the copy to the result;
 *
 * 3.Base case: The base case defines when to add step into result, and when to return.
 * 4.Use for-loop: Usually we need a for loop to iterate though the input String s, so that we can choose all the options.
 * 5.Choose: In this problem, if the substring of s is palindrome, we add it into the step, which means we choose this substring.
 * 6.Explore: In this problem, we want to do the same thing to the remaining substring. So we recursively call our function.
 * 7.Un-Choose: We draw back, remove the chosen substring, in order to try other options.
 */
public class Solution78 {
    /** brutal force
     * backtracking approach
     * Time complexity O(2^n)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    /**
     *
     * @param list
     * @param tempList
     * @param nums
     * @param start
     *
     * e.g.
     * [1,2,3]
     * i=0: tempList[1], backtrack(i=1)...
     * list[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
     */
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        //add tempList to the list,the first one is []
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);//add num[0] to the tempList
            backtrack(list, tempList, nums, i + 1);//try other numbers start num[1] to fill in the tempList
            tempList.remove(tempList.size() - 1);//remove the numbers added once i reach the nums.length
        }
    }
    public static void main(String[]args){
        Solution78 ns =new Solution78();
        int[] nums = new int[] {1,2,3,4};
        System.out.println(ns.subsets(nums));
    }
}
