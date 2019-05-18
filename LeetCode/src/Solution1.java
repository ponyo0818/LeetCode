/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers, return indices of the two numbers such that they add up
 * to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use
 * the same element twice.
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**on pass Hash Table
 * While we iterate and inserting elements into the table, we also look back to check if current
 * element's complement already exists in the table. If it exists, we have found a solution and
 * return immediately.
 */

public class Solution1 {
    public int[] twoSum (int [] nums, int target){
        //create a new hash map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < nums.length; i++){
            //get the complement of the current element
            int complement = target - nums[i];
            //check if current element's complement exists in the hash table
            if (map.containsKey(complement)){
                //return the indexes formatted in an array instantly, as we assume only one solution
                return new int[] {map.get(complement), i};
            }
            //insert element (key-value of the element, value-index) into the table
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main (String [] args){
        Solution1 newsolution = new Solution1();
        int nums [] = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] result = newsolution.twoSum(nums, target);
        //the way to print an array
        System.out.println(Arrays.toString(result));
    }
}
