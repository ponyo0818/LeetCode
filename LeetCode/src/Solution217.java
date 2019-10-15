import java.util.*;

/**
 * 217. Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 *
 * Time complexity : O(n)
 */

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> nh = new HashSet<>();
        for (int item: nums){
            if (nh.contains(item)){
                return true;
            }
            nh.add(item);
        }
        return false;

    }
}
