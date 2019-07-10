import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class Solution139 {
    /**
     * First DP approach
     * @param s
     * @param wordDict
     * @return
     * n-length of s
     * Time complexity: O(n^3) since Substring method would be O(n) operation.
     */
    public boolean wordBreak1(String s, List<String> wordDict){
        //create a boolean to record the status of each break
        //s.length() +1 is because it need to store [0,1....s.length()]
        //for example "antand" s.length() is 6, the last it store is canBreak[6], from canBreak[0] to canBreak[6]
        //there is 7 items in the boolean list
        boolean[] canBreak = new boolean[s.length()+1];

        canBreak[0] = true;
        //set two pointers, j is the start of a substring, i is the end of a substring
        //mark the canBreak[i] to true once canBreak[j] is true && find the substring(j,i) in the dict
        for (int i=1; i<= s.length();i++){
            for(int j=0; j<i;j++){
                if(canBreak[j]&& wordDict.contains(s.substring(j,i))){
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    /**
     * Second DP approach
     * Time complexity O(n*m)
     * n is length of s, m is the size of dictionary
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String>wordDict){
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0]=true;
        for(int i=1; i<=s.length();i++){
            for(String word:wordDict){
                if(word.length()<=i){
                    if(canBreak[i-word.length()]&&s.substring(i-word.length(),i).equals(word)){
                        canBreak[i] = true;
                        break;
                    }
                }
            }
        }
        return canBreak[s.length()];
    }

}
