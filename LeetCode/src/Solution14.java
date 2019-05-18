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
     * Time complexity : O(S), where S is the sum of all characters in all strings.
     * @param strs
     * @return
     */
    public String longestCommonPrefixHS(String[] strs){
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

    /**
     * Approach 2: Binary search
     * Time complexity : O(S .log n), where SS is the sum of all characters in all strings.
     * @param strs
     * @return
     */
    public String longestCommonPrefixBS(String [] strs){
        if (strs == null || strs.length ==0) return "";
        //minLen is the min string length and the max possible common prefix
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());//iterate the list to find the minLen
        /**
         * Explain: why low = 1?
         * leets
         * 01234 low=1,high=minLen=5,middle=(1+5)/2=3(t), thus (0,3) is 'lee', (3,5) is 'ts'
         */
        int low =1;
        int high = minLen;
        //loop until there is only one character left in the strs[i], return the longest common prefix
        while (low <= high){
            int middle = (low + high)/2;
            //if the leaf side has common prefix, discard the left half
            if (isCommonPrefix (strs, middle)) low = middle +1;
            //otherwise, discard the right half
            else high = middle -1;
        }
        return strs[0].substring(0, (low+high)/2);
    }
    //a method check if all the strings in the strs[] has the common prefix
    private boolean isCommonPrefix(String [] strs, int len){
        //create the instance of a substring of strs[0]
        String str1 = strs[0].substring(0, len);
        //iterate all the String in the strs[]
        for (int i=1; i<strs.length; i++){
            //if any strs[i] not start with the current prefix, return false
            if (!strs[i].startsWith(str1)) return false;
        }
        return true;
    }

    public static void main (String [] args){
        Solution14 newsolution = new Solution14();
        String [] s = new String[] {"flower","flow","flight"};
        String answer1 = newsolution.longestCommonPrefixHS(s);
        System.out.println(answer1);
        String answer2 = newsolution.longestCommonPrefixBS(s);
        System.out.println(answer2);
    }

}
