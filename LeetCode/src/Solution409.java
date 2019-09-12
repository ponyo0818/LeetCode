import java.util.HashSet;

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Solution: need to know how many pairs of characters in the String S
 * 1. use s.charAt(i) to locate the character in the string
 * 2. Use hashset, which does not store reduplicate values to count the number of pairs.
 * 3. Remember to add 1 to the count*2 if the hashset is not empty at the end.
 */
public class Solution409 {
    /**
     * Time complexity: O(n)
     * @param s
     * @return
     */
    public int longestPalindrome (String s){
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> hs = new HashSet<>();
        int count =0;
        for (int i = 0; i < s.length(); i++){
            if (hs.contains (s.charAt(i))){
                hs.remove(s.charAt(i));
                count ++;
            }
            else{
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) return count * 2 + 1;//odd number,can only add one to the count e.g. bab
        return count * 2; //even number, e.g. aaaa
    }
    public static void main (String [] args){
        Solution409 ns = new Solution409();
        System.out.println(ns.longestPalindrome("aaabbccc"));
    }
}

