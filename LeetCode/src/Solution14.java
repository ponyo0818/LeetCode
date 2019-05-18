/**
 * 14. Longest Common Prefix
 *  https://leetcode.com/problems/longest-common-prefix/
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 */

public class Solution14 {
    /**Approach 1: Horizontal scanning
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0) return "";
        //initial the prefix with the first string as the common prefix
        String prefix = strs[0];
        //iterates through the strs
        for (int i = 1; i < strs.length; i++){
            //loop until find a common prefix which the first occurrence is at position 0
            while (strs[i].indexOf(prefix) !=0){
                //shorten the prefix by 1 each time
                prefix = prefix.substring(0, prefix.length()-1);
                //end if prefix is an empty string
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main (String [] args){
        Solution14 newsolution = new Solution14();
        String [] s = new String[] {"flower","flow","flight"};
        String answer = newsolution.longestCommonPrefix(s);
        System.out.println(answer);
    }

}
