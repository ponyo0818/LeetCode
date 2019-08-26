/**
 * 171. Excel Sheet Column Number
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 */

public class Solution171 {
    /**
     * 'a' = 97, 'A'= 65, and there is 26 numbers
     * AB = 'A' * 26 + 'B'
     * @param s
     * @return
     */
    public int titleToNumber(String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            sum = sum * 26 + (s.charAt(i) - 'A' + 1);
        }
        return sum;

    }
    public static void main (String [] args){
        Solution171 ns = new Solution171();
        String s = "BA";
        System.out.println (ns.titleToNumber(s));
    }

}
