/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * they are 1, 5, 10, 50, 100, 500, 1000 respectively
 *
 * 1. Roman numerals are usually written largest to smallest from left to right.
 * 2. There are some special cases:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */


public class Solution13 {
    public static int romanToInteger(String s){
        int sum = 0;
        //iterate in the reverse order, as Roman numerals are written largest to
        // smallest from left to right in most cases
        for (int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            //the switch statement display the value of 'sum' based on the Symbols
            switch (c){
                case 'I':
                    sum += (sum >=5 ? -1:1);
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10 * (sum >= 50? -1:1);
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100 * (sum >= 500? -1:1);
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
            }
        }
        return sum;
    }

    public static void main (String [] args){
        Solution13 newsolution = new Solution13();
        //If the first sequence of non-whitespace characters in str is not a valid integral number,
        // or if no such sequence exists because either str is empty or it contains only whitespace characters,
        // no conversion is performed.
        String s = "III";
        int answer = newsolution.romanToInteger(s);
        System.out.println(answer);
    }
}
