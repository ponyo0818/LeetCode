import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 *
 *
 */


public class Solution17 {
    //create a HashMap, digit is the key, letter is the value
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    //declare the result as an ArrayList (class variable)
    List<String> output = new ArrayList<String>();

    /**
     * Approach 1: Backtracking (one of the Brute force algorithms)
     * Backtracking is an algorithm for finding all solutions by exploring all potential candidates.
     * If the solution candidate turns to be not a solution (or at least not the last one), backtracking
     * algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.
     * @param combination
     * @param next_digits
     *
     *
     * Time complexity : O(3^N * 4^M)
     * where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8)
     *  and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total
     *  number digits in the input.
     */

    //Here is a backtrack function backtrack(combination, next_digits) which takes as arguments an ongoing letter
    // combination and the next digits to check.
    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // add the combination to the output ArrayList
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            //get the letters that in correspond to digit
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                //* Using + Operator is one of the easiest way to concatenate two strings in java
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            //initialize the combination with an empty string
            backtrack("", digits);
        return output;
    }

    public static void main (String [] args){
        Solution17 newsolution = new Solution17();
        String digits = "345";
        List<String> result = newsolution.letterCombinations(digits);
        System.out.println (result);
    }
}
