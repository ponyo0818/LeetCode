import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * Easy
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five
 * output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * https://leetcode.com/problems/fizz-buzz/
 *
 */

public class Solution412 {
    public List<String> fizzBuzz(int n){
        List<String> result = new ArrayList<>();
        for (int i =1; i<= n; i++){
            if(i%3 ==0 && i%5 ==0){
                result.add("FizzBuzz");
            }
            else if (i%3 == 0){
                result.add("Fizz");
            }
            else if (i%5 == 0){
                result.add("Buzz");
            }
            else{
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
    public static void main (String [] args){
        Solution412 ns = new Solution412();
        System.out.println(ns.fizzBuzz(15));
    }
}
