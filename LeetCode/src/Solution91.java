/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 */
public class Solution91 {
    /**
     * Dynamic Programming approach
     * Time: should be O(n), where n is the length of String
     * Space: should be O(n), where n is the length of String
     * @param s
     * @return
     * 22034
     * dp[0]=1
     * dp[1]=1
     * dp[2]: first=s[1,2]=2 ->dp[2]=dp[1]=1
     *         second=s[0,2]= 22 ->dp[2]=dp[0]+dp[2]=2
     * dp[3]: first=s[2,3]=0 -> skip
     *         second=s[1,3]=20 ->dp[3]+=dp[1]=1
     * dp[4]: first=s[3,4]=3-> dp[4]+=dp[3]=1
     *          second =s[2,4]=03 skip
     * dp[5]: first=s[4,5]=4 ->dp[5]=1
     *          second =s[3,5]=34 skip
     *return d[5]=1
     *
     * Key:
     * as the number increase 1 to its right, it won't increase the numDecode if [i-2,i] is not fall into[10,26]
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        //dp[i]: represents possible decode ways to the ith char(include i), whose index in string is i-1
        int[] dp = new int[n+1];
        //Base case: dp[0] = 1 is just for creating base; dp[1], when there's one character,
        // if it is not zero, it can only be 1 decode way. If it is 0, there will be no decode ways.
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        //Here only need to look at at most two digits before i, cuz biggest valid code is 26, which has two digits.

        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            //System.out.println("first: "+first+"second: "+second);
            //First check if substring (i-1,i) is 0 or not. If it is 0, skip it, continue right to check substring (i-2,i),
            // cuz 0 can only be decode by being together with the char before 0.
            //Second, check if substring (i-2,i) falls in 10~26. If it does, means there are dp[i-2] more new decode ways.
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
                //System.out.println("i: "+i+" dp: "+dp[i]+" first: "+ first);
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
                //System.out.println("i: "+i+" dp: "+dp[i]+" second: " + second);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution91 ns =new Solution91();
        String s= "22034";
        System.out.println(ns.numDecodings(s));
    }
}
