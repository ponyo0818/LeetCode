/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * m
 * 1 1 1  n
 * 1 1 1
 *
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 */
public class Solution62 {
    /**
     * Dynamic Programming approach
     * Time complexity O(m*n)
     * Space complexity O(n*n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //return 0 when m or n ==0
        if (m == 0 || n == 0) {
            return 0;
        }
        Integer[][] map = new Integer[m][n];
        //the first row are all equal to 1
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        //the first column are all equal to 1
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        //For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

    /**
     * USe the Probability formula that how many combination that select k from N
     * N!/(k!(N-k)!
     * Time complexity O(m)
     * Space complexity O(1)
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsFM(int m, int n){
        int N = n + m - 2; // how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        long res = 1;
        // here we calculate the total possible path number Combination(N, k) = N! / (k!(N - k)!)
        // reduce the numerator and denominator and get C = ( (N - k + 1) * (N - k + 2) * ... * N ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int) res;
    }

    public static void main (String [] args){
        Solution62 ns = new Solution62();
        System.out.println(ns.uniquePaths(5,5));
    }
}
