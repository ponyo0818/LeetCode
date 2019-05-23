import java.util.List;
import java.util.ArrayList;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Solution22 {
    /**
     * Backtracking solution
     * Backtracking is an algorithmic-technique for solving problems recursively by trying to build a solution
     * incrementally, one piece at a time, removing those solutions that fail to satisfy the constraints of the
     * problem at any point of time
     *
     * Time Complexity : O((4^n)\sqrt(n))Each valid sequence has at most n steps during the backtracking procedure.
     * @param n
     * @return
     */
    public List<String> generateParenthesis (int n) {
        List<String> list = new ArrayList<String>();
        //list of combination, current combination, open parenthesis, close parenthesis, n
        backtrack (list, "", 0, 0, n);
        return list;
    }
    public void backtrack(List<String> list, String str, int open, int close, int max){
        if (str.length() == max*2){
            list.add(str);
            return;
        }
        if (open < max) backtrack (list, str +"(", open+1, close, max);
        if (close < open) backtrack (list, str +")", open, close+1, max);
    }

    public static void main (String[]args){
        Solution22 newSolution = new Solution22();
        List result = newSolution.generateParenthesis(4);
        System.out.println(result);
    }
}

