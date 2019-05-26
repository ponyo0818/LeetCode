/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 *
 *
 * the main idea is that we need to find some parts of array that we could adopt binary search on that, which means we
 * need to find some completed sorted parts, then determine whether target is in left part or right part. There is at
 * least one segment (left part or right part) is monotonically increasing.
 *
 *
 * & is bitwise. && is logical.
 *
 * & evaluates both sides of the operation.
 * && evaluates the left side of the operation, if it's true, it continues and evaluates the right side.
 *
 * Time complexity O(log(n))
 * Space complexity O(1)
 */


public class Solution33 {
    public int search(int[] nums, int target){
        if (nums.length == 0) return -1; //conner case that is an empty array
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            //the mid we be update everyday as the end and start being updated
            int mid = (start + end)/2;
            if (target == nums[mid]) return mid;
            //if the left part is monotonically increasing sorted
            //[4,5,6,7,1,2,3] [3]
            if (nums[start] <= nums[mid]){
                //if the target is in the left part, set the end to the mid
                if(target >= nums[start] && target < nums[mid]){
                    end = mid -1;
                }
                //if not, should be in the right part, discard the left part
                else start = mid +1;
            }

            //if the right part is monotonically increasing sorted
            //[5,6,7,1,2,3,4] [5]
            else{
                if(target > nums[mid] && target <= nums[end]){
                    start = mid +1;
                }
                else end = mid -1;
            }
        }
        //conner case that target = sums[0] or sums[nums.length -1]
        return -1;
    }
    public static void main (String [] args) {
        Solution33 newSolution = new Solution33();
        int[] nums = new int[]{5, 1, 3};
        int target = 3;
        System.out.println(newSolution.search(nums, target));
    }
}
