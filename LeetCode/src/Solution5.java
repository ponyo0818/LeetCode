/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Dynamic programming
 * dp(i, j) represents whether s(i ... j) can form a palindromic substring,
 * dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
 * When we found a palindrome, check if it's the longest one. Time complexity O(n^2).
 */
class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        //initial the sub-string
        String res = "";


        boolean[][] dp = new boolean[n][n];
        //two pointer, right i move backward, left j move forward
        // dp[i][j] is derived from the dp[i + 1][j - 1] as for i we must know i + 1
        // so the first loop must come from the end of the string
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                //dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                //update the longest palindromic substring
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;

    }

    public static void main (String [] args){
        Solution5 newsolution = new Solution5();
        String answer = newsolution.longestPalindrome("aaaaaa");
        System.out.println(answer);

    }
}