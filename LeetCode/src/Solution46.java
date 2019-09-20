import java.util.List;
import java.util.ArrayList;

/**
 * 46. Permutations 排列
 *https://leetcode.com/problems/permutations/
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Use backtracking approach
 * Time complexity:O(n^2) as for every element it scans all the elements in the array and rejects the one which are already added
 * he space complexity is O(n!)
 *
 * 用回溯法来做这道题，简单的思路就是第一层loop决定了用哪个数字来开头，追溯的作用是用递归来往接下来的位置尝试填入各种nums里的数字（如果已经用过就跳过），
 * 当这个tempList填满（等于nums的长度），就添加到最终返回的list里面。这样可以保证所有的组合都不会重复。
 * the simple idea is that the outer loop determines which number to start with. The purpose of the backtracking is to use recursion to
 * try to fill in the numbers in nums in the next position (skip if used it),When this tempList is fully filled
 * (equal to the length of nums), added it to the final list. This will ensure that all combinations are not repeated.
 */

public class Solution46 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        /** size() for ArrayList, length for array to return the number of elements */
        if(tempList.size() == nums.length){
            //when the tempList reach the length of nums, add to the final list
            list.add(new ArrayList<>(tempList)); //created a new ArrayList whose elements are the same as tempList so clean the tempList does not effect this
        }
        else{
            //i=0, start to fill the nums[0] to the tempList[0], try all different numbers in a certain position
            // after all the backtracking done, clear the tempList, then i=1, start to fill the nums[1] to the
            // tempList[0], build all permutations starting with nums[1]...end when i=nums.length
            for (int i=0; i<nums.length; i++){
                if(tempList.contains(nums[i])) continue;//if the nums[i] already exists in the tempList. skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() -1);
            }
        }
    }

    public static void main(String [] args){
        Solution46 ns = new Solution46();
        int[] nums = new int[] {1,2,3};
        System.out.println(ns.permute(nums));
        /**ArrayList can be printed directly, Array need "System.out.println(Arrays.toString(array))" */
    }
}
