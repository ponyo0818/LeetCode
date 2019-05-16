/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line
 * i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *  Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 */

public class Solution11 {
    /**
     * Approach 1: Brute Force
     * Time complexity : O(n^2)
     * @param height
     * @return
     */
    public int maxAreaBF(int[] height) {
        int maxarea = 0;
        //pointer j is always on the right of pointer i
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                //update the max area, the max area = the min height * (j-i)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    /**
     * Approach 2: Two Pointer Approach
     * Time complexity : O(n)
     *
     * The intuition behind this approach is that the area formed between the lines will
     * always be limited by the height of the shorter line. Further, the farther the lines,
     * the more will be the area obtained.
     *
     * We take two pointers, one at the beginning and one at the end of the array constituting
     * the length of the lines. Further, we maintain a variable 'maxarea' to store
     * the maximum area obtained till now. At every step, we find out the area formed between them,
     * update 'maxarea' and move the pointer pointing to the shorter line towards the
     * other end by one step.
     *
     * @param height
     * @return
     */
    public int maxAreaTP(int[] height) {
        //left pointer l, right pointer r
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));//the same as the BF approach
            //always move the shorter line inward
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main (String [] args){
        Solution11 newsolution = new Solution11();
        //If the first sequence of non-whitespace characters in str is not a valid integral number,
        // or if no such sequence exists because either str is empty or it contains only whitespace characters,
        // no conversion is performed.
        int [] lines = new int[] {1,8,6,2,5,4,8,3,7};
        int answer = newsolution.maxAreaTP(lines);
        System.out.println(answer);
    }

}
