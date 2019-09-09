/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Prime number: A prime number is a whole number greater than 1 whose only factors are 1 and itself.
 *
 * The key solution of this question is:
 * 1. Mark all the numbers which have factors more than 1 and itself
 * 2. All the other numbers are Prime number.
 */
public class Solution204 {
    public int countPrimes(int n){
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i< n ; i++){
            if (!notPrime[i]){
                count ++;
            }
            for (int j = 2; i*j < n; j++){
                notPrime[i*j] = true;
            }
        }
        return count;
    }
    public static void main (String[] args){
        Solution204 ns = new Solution204();
        System.out.println (ns.countPrimes(10));
    }

}
