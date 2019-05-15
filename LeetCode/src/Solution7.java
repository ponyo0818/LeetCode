/**
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 * https://leetcode.com/problems/reverse-integer/
 * Example 1:
 *
 * Input: 123
 * Output: 321
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your
 * function returns 0 when the reversed integer overflows.
 *
 * The int data type is a 32-bit signed two's complement integer.
 * It has a minimum value of -2,147,483,648 and a maximum value of 2,147,483,647 (inclusive).
 */


public class Solution7 {
    public int reverse(int x){
        int result = 0;
        while (x != 0){
            //the last digit
            int tail =  x % 10;
            int newResult = result * 10 + tail;
            //If overflow exists, the new result will not equal previous one.
            if((newResult - tail)/10 != result){
                return 0;
            }
            result =  newResult;
            //as result stays int, update the x that removing the last digit
            x = x/10;
        }
        return result;
    }

    public static void main (String [] args){
        Solution7 newsolution = new Solution7();
        int answer = newsolution.reverse( 214748364);
        System.out.println(answer);
    }
}


