import java.util.HashMap;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 */

public class Solution20 {
    /**
     * Stack approach
     * iterate the string, push the open parentheses onto the stack, keep check the close parentheses in the string,
     * once found, pop the open parentheses in the stack.
     *
     * Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop
     * operations on a stack take O(1) time.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //create a stack
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            // Check stack for corresponding closing parentheses, false if not valid
            //java.util.Stack.peek() method return the top item at the stack
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        //* stack empty() is of boolean type and return true if the stack is empty
        return stack.empty();
    }

    /**
     * Stack and using switch approach
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.size() == 0 || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != '[')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
    public static void main (String [] args){
        Solution20 newsolution = new Solution20();
        String s = "((()))[]";
        System.out.println(newsolution.isValid2(s));
    }

}
