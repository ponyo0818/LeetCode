/**
 * 191. Number of 1 Bits
 * Easy
 *
 * 492
 *
 * 412
 *
 * Favorite
 *
 * Share
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 *
 * --------------
 *  Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should
 *  not affect your implementation, as the internal binary representation of the integer is the same whether it is
 *  signed or unsigned.
 */

public class Solution191 {
    /**
     * Shift the binary representation of the integer to the left, and check the last digit of the integer (count 1)
     * @param n
     * @return
     */
    public int hammingWeight(int n){
        int count = 0;
        for (int i =0; i < 32; i++){
            if ((n&1) == 1) count ++;
            n >>= 1;
        }
        return count;
    }

    public static void main (String[]args){
        Solution191 ns =new Solution191();
        System.out.println(ns.hammingWeight(5));
    }
}
