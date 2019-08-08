import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/solution/
 * 169. Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

public class Solution169 {
    //Approach 1. Brute force. Time complexity : O(n^2), space complexity: O(1)
    public int majorityElement(int[] nums) {
        int halfLength = nums.length/2;

        for (int num : nums){
            int count = 0;
            for (int elements : nums){
                if (num == elements) count++;
            }
            if (count>halfLength) return num;
        }
        return -1;
    }
    //Approach 2. Hashmap Time and space complexity: O(n)
    public int MajorityElements2(int[] nums){
            Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
            int halfLength = nums.length/2;
            //HashTable<Integer, Integer> myMap = new HashTable<Integer, Integer>();
            for (int num :nums){
                if (!myMap.containsKey(num))
                    myMap.put(num,1);
                else
                    myMap.put(num, myMap.get(num)+1);
                //check weather the count is greater than the half of length
                if (myMap.get(num) > halfLength)
                    return num;
            }
            return -1;
    }
    //Approach 3. Sorting Time complexity : O(nlgn) Space complexity : O(1) or O(n))
    //If the elements are sorted in monotonically increasing (or decreasing) order, the majority element
    // can be found at index n/2 or n/2+1 if n is even
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main (String[]args){
            Solution169 ns = new Solution169();
            int[] nums =new int[]{2,2,3,3,3,3};
            System.out.println(ns.MajorityElements2(nums));
    }

}
