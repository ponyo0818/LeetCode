import java.util.Arrays;
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
 * because we are locating an range, so the algorithm does not terminate as soon as we find a match
 *
 * Time complexity O(logN)
 *
 */
public class Solution34 {
    private int extremeInsertionIndex(int[] nums, int target, boolean left){
        //initial low and high
        int lo = 0;
        int hi = nums.length;
        //stop when lo = hi
        while (lo < hi){
            int mid = (lo + hi)/2;
            //if mid is the target, or mid is greater than the target, set mid to hi
            //About boolean left if left is true, then we "recurse" on the left subarray on ties. Otherwise, we go right.
            if (nums[mid] > target || (left&&target == nums[mid])) hi = mid;
            //otherwise (mid is lower than target), set lo to mid+1
            else lo = mid+1;

        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target){
        int[] targetRange = {-1,-1};
        //get the left most index
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

    public static void main (String [] args){
        Solution34 sl = new Solution34();
        int[] nums = {1,2,3,4,5,6,6,7};
        System.out.println(Arrays.toString(sl.searchRange(nums, 6)));
    }
}
