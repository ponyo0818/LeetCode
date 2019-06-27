/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        int front=0;
        int end = s.length() -1;
        while(front<end){
            while(front<s.length()&&!isvalid(s.charAt(front))){
                front++;
            }
            //if no letter in the string
            if(front ==s.length()){
                return true;
            }
            while(end>=0&& !isvalid(s.charAt(end))){
                end--;
            }

            if(Character.toLowerCase(s.charAt(front))!=Character.toLowerCase(s.charAt(end))){
                break;
            }
            else {
                front++;
                end--;
            }
        }
        return end<=front;
    }

    public boolean isvalid(char c){
        return Character.isLetter(c)||Character.isDigit(c);
    }

    public static void main(String[] args){
        Solution125 ns = new Solution125();
        String s = "abba";
        System.out.println(ns.isPalindrome(s));
    }

}
