/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class Solution69 {
    /**
     * Solution1 - Binary Search Solution: Time complexity = O(lg(x)) = O(32)=O(1)
     * @param x
     * @return
     *
     * For folks wondering what is the (mid + 1) > x / (mid + 1) for: it is to prevent overflow.
     * If (mid + 1)*(mid + 1) overflows the 32 bit int limit, you might end up with an infinite loop.
     */
    public int mySqrt(int x){
        if (x ==0) return 0;
        int start =1, end =x;
        while(start<end){
            int mid = start+(end -start)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1)) return mid; //found the result when  mid*mid<= x < (mid+1)(mid+1)
            else if(mid > x/mid) end =mid; //when mid*mid greater than x, check the left part
            else start=mid+1; //otherwise, check the right part
        }
        return start; //return end also works
    }

    public static void main(String[]args){
        Solution69 ns =new Solution69();
        System.out.println(ns.mySqrt(5));
    }
}
