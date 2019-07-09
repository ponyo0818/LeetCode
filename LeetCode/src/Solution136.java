import java.util.HashMap;
import java.util.HashSet;

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class Solution136 {
    /**
     * Approach 1 Using HashMap
     * @param nums
     * @return
     * O(n) time complexity and space complexity
     * About HashSet and HashMap
     * 1. HashSet is a set, e.g. {1, 2, 3, 4, 5, 6, 7},
     *
     * HashMap is a key -> value pair(key to value) map, e.g. {a -> 1, b -> 2, c -> 2, d -> 1}
     *
     * 2. HashSet is slower then HashMap,
     *
     * 3. HashSet does’t allow duplicate values. HashMap store key, value pairs and it does not allow
     * duplicate keys. If key is duplicate then old key is replaced with new value.
     */
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int i=0;
        for(int num:nums){
            if(hashMap.containsKey(num)) hashMap.remove(num);
            else hashMap.put(num,i++);
        }
        int answer =-1;//initial the answer, -1 when no key exist
        for(int key:hashMap.keySet()){
            answer=key;
        }
        return answer;
    }

    /**
     * Approach 2 Hashset
     * @param nums
     * @return
     * O(n) time complexity and space complexity
     */
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            if(!set.remove(num)) set.add(num);
        }
        return set.iterator().next();//create an iterator and return the value
    }

    /**
     * Approach 3-bitwise XOR
     * 0 ^ N = N
     * N ^ N = 0
     * So..... if N is the single number
     *
     * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
     *
     * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
     *
     * = 0 ^ 0 ^ ..........^ 0 ^ N
     *
     * = N
     * @param nums
     * @return
     *
     * O(n) time complexity, O(1) space complexity
     */
    public int singleNumber3(int[] nums) {
        int ans =0;
        int len = nums.length;
        for(int i=0;i<len;i++)
            ans ^= nums[i];

        return ans;

    }

    public static void main(String[]args){
        Solution136 ns =new Solution136();
        int[] nums =new int[]{4,1,2,1,2};
        System.out.println(ns.singleNumber1(nums));
    }
}
