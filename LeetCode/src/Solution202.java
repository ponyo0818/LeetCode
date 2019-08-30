/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */

import java.util.HashSet;

public class Solution202 {
    /**
     * Time complexity: O(1) to O(n)?
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> number = new HashSet<>(); //a hashset to store the value
        while (!number.contains(n)){
            number.add(n); //Or while (number.add(n)), it won't insert the duplicate value and return false
            int temp = 0;
            while (n > 0){
                temp += (n%10)*(n%10); //sum the squares of its digits
                n/=10;
            }
            n = temp;
            if (n == 1) return true;
        }
        return false;
    }
    public static void main (String[]args){
        Solution202 ns =new Solution202();
        System.out.println(ns.isHappy(19));
    }
}
