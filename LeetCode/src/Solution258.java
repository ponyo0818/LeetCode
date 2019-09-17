/**
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *
 * Take 123 as an example
 * 123= 1+2+3
 * 123%10 = 3  123/10 = 12
 * 12%10 = 2 12/10 = 1
 * 1%10 = 1  1/10 = 0
 */
public class Solution258 {
    public int addDigits (int num) {
        while (num / 10 > 0) { //check if it is greater than 10
            num = sumDigits(num);
        }
        return num;
    }
    public int sumDigits(int n){
        if (n == 0) {
            return 0;
        }
        return n%10 + n/10;
    }


    public static void main (String [] args){
        Solution258 ns = new Solution258();
        System.out.println(ns.addDigits(38));
    }
}
