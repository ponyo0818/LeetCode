import java.util.List;
/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
 * and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * "It doesn't matter what you leave beyond the returned length" ！！
 */
public class Solution26 {
    //return the length of the array after removed duplicates

    /**
     * this is very similar as the Two pointers approach in the LeetCode solution
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
     * the loop "for (int n:nums)" is the fast pointer which will go through the whole array
     * while, the i is the slow pointer which only increment while found a new number
     *
     * Time complextiy : O(n). Assume that n is the length of array.
     * Space complexity : O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0; //the first number stay in the same place
        for (int n : nums)
            if (i == 0 || n > nums[i-1])//if the current number is greater than the previous one, set it there and increase the i
                nums[i++] = n; //is equal to nums[i] =n; i++
        return i;
    }
    public static void main(String [] args) {
        Solution26 newSolution = new Solution26();
        int[] nums = new int[]{1, 1, 2};
        int result = newSolution.removeDuplicates(nums);
        System.out.println(result);
    }
}
