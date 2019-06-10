import java.util.Arrays;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * -----------------
 * 1. A default value of 0 for arrays of integral types is guaranteed by the language spec
 * when create an int array: int[] ary = new int[4] -> [0,0,0,0]
 *
 */
public class Solution66 {
    /**
     * Iterative Approach
     * Time complexity: O(n)
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        //traverse from the end of the array
        for (int i = digits.length - 1; i >=0; i--) {
            //simply increase 1 when digits is not 9, and break out of the loop
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        //when the first element is equal to 0, we need to increase the length of array,999+1=1000
        if (digits[0] == 0) {
            //create an new array
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
    public static void main(String[] args){
        Solution66 ns =new Solution66();
        int[] digits = new int[]{9,9,9,9};
        System.out.println(Arrays.toString(ns.plusOne(digits)));
    }
}
