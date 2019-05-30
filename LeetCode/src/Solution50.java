/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */
public class Solution50 {
    /**
     * Time complexity O(n)
     * @param x
     * @param n
     * @return
     */
    public double myPowSlow(double x, int n){
        double result=1.0;
        if (n>0){
            for (int i=0; i<n; i++){
                result *=x;
            }
        }
        if (n<0){
            for (int i=0; i<-n; i++){
                result *=x;
            }
            double temp =result;
            result =1.0/temp;
        }
    return result;
    }

    /**
     * Use recursive to solve this problem
     * When n is even, n%2 ==0, x^n = x^(n/2)* x^(n/2)
     * when n is odd, n%2 != 0, x^n = x^(n/2)* x^(n/2)* x
     * @param x
     * @param n
     * @return
     * Time complexity: O(log n)
     */
    public double myPow(double x, int n){
        if (n == Integer.MIN_VALUE && x>1) //will cause over flow
            return 0.0;
        if (n ==0)
            return 1;
        if (n < 0){
            n= -n;
            x = 1/x;
        }
        return (n%2 == 0)? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }


    public static void main (String [] args){
        Solution50 ns = new Solution50();
        System.out.println(ns.myPow(4,-2));
    }
}
