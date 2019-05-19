import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 * not use HashSet in this problem since HashSet will remove duplicates, we wil loose that context
 *
 * time complexity O(N^2)
 */

public class Solution15 {
    //return a list<list<integer>>
    public List<List<Integer>> threeSum(int[] num) {
        //sort the input array in ascending order
        Arrays.sort(num);
        //create an ArrayList of ArrayList
        List<List<Integer>> res = new LinkedList<>();
        //run through all indices of possible first element of triplet
        for (int i = 0; i < num.length-2; i++) {
            //num[i] is not equal to num[i-1] to avoid duplicates, e.g [-1, -1, 2, 2] return [[-1 -1, 2]]
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                //for each possible first element we make a standard binary search 2 sum sweep
                // of the remaining part of the array
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //if the adjacent number are equal, move the pointer inward
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    }
                    //if lowest and highest of the remaining part less than sum, forward the index of lowest
                    else if (num[lo] + num[hi] < sum) lo++;
                    //otherwise, downward the index of highest
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main (String [] args){
        Solution15 newsolution = new Solution15();
        int num [] = new int[] {-1, 2, -1, -2, 0};
        List<List<Integer>> result = newsolution.threeSum(num);
        //the way to print an array
        System.out.println(result);
    }
}
