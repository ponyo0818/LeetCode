/**
 * 28. Implement strStr()
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 *
 * Time complexity: O( needle.length() * haystack.length() ) = O(mn)
 */
public class Solution28 {
    /**
     * Approach 1
     * @param haystack
     * @param needle
     * @return
     */
        public int strStr1(String haystack, String needle) {
            int l1 = haystack.length(), l2 = needle.length();
            if (l2 == 0){
                return 0;
            }
            for (int i=0; i<=(l1-l2);i++){
                //use equals to judge if they have the same content
                if(haystack.substring(i, i+l2).equals(needle)){
                    return i;
                }
            }
            return -1;
        }

    /**
     * Approach 2
     * @param haystack
     * @param needle
     * @return
     *
     */

        public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                //System.out.println("i: "+i+ ",j: "+j);
                //while j reached the length of needle, return the i which is the index of the first occurrence of needle in haystack
                if (j == needle.length()) return i;
                // -1 if needle is not part of haystack
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;//if any unequal character, leave the inner loop
            }
        }
    }

        public static void main (String [] args){
            Solution28 newSolution = new Solution28();
            System.out.println (newSolution.strStr2("heeeello", "ll"));
        }
}
