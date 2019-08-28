/**
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 *
 *
 * Example 1:
 *
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 * so return 964176192 which its binary representation is 00111001011110000010100101000000.
 *
 * 1. Bitwise right shift operators:
 * >> Singed right shift
 * << Singed left shift
 * n&1 get the last digit of n
 *
 * 2. In a signed binary two's complement, first bit (the leftmost) indicates the sign,
 * 1 = negative, 0 = positive.
 *
 * IDEA: 新建一个空白list (result =0), 依次从右向左把n的bit加到result里，同时result左移腾出空位给下一个bit
 *
 */

public class Solution190 {
    // you need treat n as an unsigned value. think 'result' as a new list to save the numbers, so every time we
    // get the last digit of 'n', just shift 'result' to the left and add n (add 1 if it is 1)
    // Time complexity O(32) ? O(1)
    public int reverseBits(int n) {
        if (n ==0) return 0;
        int result = 0; //initial result to 0: 0000_0000_0000_0000_0000_0000_0000_000
        for (int i = 0; i<32; i++){
            int end = n & 1; //find the last digit of n
            n >>= 1; //right shift by 1, drop the last digit
            result <<=1; //shift the result to the left
            if(end == 1) result++; //add 1 to result when the last digit of n is 1
        }
        return result;
    }

    public static void main (String [] args){
        Solution190 ns =new Solution190();
        System.out.println(ns.reverseBits(13));
    }
}
