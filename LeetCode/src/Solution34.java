/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Because the array is sorted, we can use binary search to locate the left and rightmost indices.
 * Time complexity O(logN)
 *
 */
public class Solution34 {
    private int extremeInsertionIndex(int[] nums, int target, boolean left){
        int lo = 0;
        int hi = nums.length;

        while (lo < hi){
            int mid = (lo + hi)/2;
            //if mid is the target, or mid is greater than the target, set mid to hi
            if (nums[mid] > target || (left&&target == nums[mid])) hi = mid;
            //otherwise (mid is lower than target), set lo to mid+1
            else lo = mid+1;

        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target){
        int[] targetRange = {-1,-1};
        int leftIdx = extremeInsertionIndex(nums, target, true);
        //return [-1,-1] if target is not found
        if(leftIdx == nums.length || nums[leftIdx]!= target){
            return targetRange;
        }
        targetRange[0] = leftIdx;
        //get the right most index
        targetRange[1] = extremeInsertionIndex(nums,target,false) -1;
        return targetRange;
    }
}
