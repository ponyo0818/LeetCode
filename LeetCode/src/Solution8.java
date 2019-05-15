/**
 * 8. String to Integer (atoi)
 * Implement atoi which converts a string to an integer.
 *
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * 1. discards all leading whitespaces
 * 2. remove sign of the number
 * 3. deal with overflow
 * 4. handle invalid input, if no valid conversion could be performed, a zero value is returned.
 */
public class Solution8 {
    public int myAtoi(String str) {
        // index serve as the pointer
        // sign record the minus or plus sign
        // total record the integer
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        // be aware the index condition should be first
        while(index < str.length() && str.charAt(index) == ' ' )
            index ++;

        //3. Handle signs
        /**
         *  Conditional Operator ? :
         * The conditional operator ? : uses the boolean value of one expression to decide which of
         * two other expressions should be evaluated.
         * if (str.charAt(index) == '+')
         *      sign = 1;
         * else
         *      sign = -1;
         */
        if((index < str.length()) && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        /**
         * When covert Character to Int
         * If you know that they'll be Western digits, you can just subtract '0':
         * then check that the results are in the range 0-9
         * for example, 'A' would end up returning 17 instead of causing an error.
         */
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow (if yes return INT_MAX (231 − 1) or INT_MIN (−231) is returned.
            // if no keep adding digit
            if((Integer.MAX_VALUE-digit)/10 < total)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    public static void main (String [] args){
        Solution8 newsolution = new Solution8();
        //If the first sequence of non-whitespace characters in str is not a valid integral number,
        // or if no such sequence exists because either str is empty or it contains only whitespace characters,
        // no conversion is performed.
        int answer = newsolution.myAtoi( "  f       214748364");
        System.out.println(answer);
    }
}
