import java.util.Arrays;

/**
 * 189. Rotate Array
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class Solution189 {
    /**
     * Approach 1 BF
     * Time complexity : O(n*k) All the numbers are shifted by one step O(n)k times O(k).
     * Space complexity : O(1) No extra space is used.
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k){
        int length =nums.length;
        for (int i = 0; i < k; i++){
            int last = nums[length -1]; //store the value of the last element in the array
            //rotate the array backward
            for (int j = length -1; j>0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }

    /**
     * This approach is based on the fact that when we rotate the array k times, k%nk elements from the back end
     * of the array come to the front and the rest of the elements from the front shift backwards.
     * Steps:
     * 1. reverse all the elements of the array.
     * 2. reverse first k elements
     * 3. reverse the rest n - k elements
     *
     * Time complexity : O(n). n elements are reversed a total of three times.
     *
     * Space complexity : O(1). No extra space is used.
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k){
        k %= nums.length; //if we rotate an array equal to its size, it will turn out to be the same
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

    }
    public void reverse (int [] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main (String [] args){
        Solution189 ns = new Solution189();
        int [] nums = new int [] {1,2,3,4,5,6};
        ns.rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
