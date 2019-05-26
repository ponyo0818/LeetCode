/**
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * ---------------------
 * ABOUT LONG vs INTEGER
 * The fundamental difference between an int and long data type is the width of each type. The datatype int has the width
 * of 32-bit for the variable of int type. On the other hand, the data type long has the width of 64-bit
 * for the variable of long type.
 * ---------------------
 *
 * Say dividend / divisor = N
 * The complexity will be O((logN)^2).
 *
 * Take a look at the worst case:
 * dividend = 1+2+4+8+16... = 2*N + 1
 * divisor = 2
 * Then in the first loop, the time complexity will be log(N),
 * and in the second run, it will reduce to log(N/2) = logN - 1,
 * so the total number of steps will be 1+2+...+ logN-1+ logN = O((logN)^2).
 */

public class Solution29 {
    public int divide(int dividend, int divisor) {
        //check whether the end result is positive or negative
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        // to deal with overflow. there are so many corner cases which will lead to overflow. So it is better
        // to convert them to long first, and convert it back to integer when returning the value.
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;

        //division is actually the backward of multiplication, the task is to find the multiplication
        while(absDividend >= absDivisor){
            //set tmp as divisor, and count to 1
            long tmp = absDivisor, count = 1;
            while(tmp <= absDividend){
                tmp <<= 1; //shift a bit to the left, which is same as multiply 2 but without using multiplication
                count <<= 1;
            }
            // right shift both tmp and count by 1
            result += count >> 1; //add the count to the result
            absDividend -= tmp >> 1;//subtract the tmp from dividend
        }
        //check if the sign is positive or negative. If it is negative, then we apply negation ~result + 1 (two's complement)
        //*NEGATION implement by using the ~ operator,reverses each of the bits in a value. All of the 0s become 1s and vice versa
        //Invert the number and add 1
        //for example:
        //-9 is 11111111 11111111 11111111 11110111
        //9  is 00000000 00000000 00000000 00001001

        //Also make sure to check if result is overflow,if overflow, return the max value.

        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    public static void main (String [] args){
        Solution29 newSolution = new Solution29();
        System.out.println(newSolution.divide(35, 2));
    }
}
