import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * Time complexity is O(n*(2^n)). The function isPal is O(n)
 *
 * For a string with length n, there will be (n - 1) intervals between chars.
 * For every interval, we can cut it or not cut it, so there will be 2^(n - 1) ways to partition the string.
 * For every partition way, we need to check if it is palindrome, which is O(n).
 * So the time complexity is O(n*(2^n))
 */

public class Solution131 {
    public List<List<String>> partition(String s) {
        //create the 2d and 1d ArrayList
        List<List<String>> resList= new ArrayList<List<String>>();
        List<String> curList = new ArrayList<String>();
        dfs(s,0,curList,resList);
        return resList;
    }

    public void dfs(String s, int pos, List<String> curList, List<List<String>> resList){
        //while position reaches the end, add the current list to the result list
        if(pos==s.length()) resList.add(new ArrayList<String>(curList));
        else{
            for(int i=pos;i<s.length();i++){
                if(isPal(s,pos,i)){
                    curList.add(s.substring(pos,i+1));
                    dfs(s,i+1,curList,resList);
                    //The object of curList for one loop of the result, is just one obj.
                    // So the item in the list should be clean after it has been userd
                    curList.remove(curList.size()-1);
                }
            }
        }
    }
    //method checking if string is palindrome
    public boolean isPal(String s, int low, int high){
        while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
        /**
         * while(low<high){
         *  if(s.charAt(low)!=s.charAt(high) return false;
         *  low++;high--;
         *  }
         */
        return true;
    }

    public static void main(String[]args){
        Solution131 ns =new Solution131();
        String s = "aab";
        System.out.println(ns.partition(s));
    }
}
