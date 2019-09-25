/**
 *912. Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Time complexity O(nlogn), O(n2) worst case
 *
 */

import java.util.Arrays;

public class Solution912 {

    public int[] sortArray(int[] nums){
        quickSort(nums, 0, nums.length -1);
        return nums;
    }

    public static void quickSort(int[] nums, int low, int high){
        //check for empty or null array
        if (nums.length == 0 || nums == null){
            return;
        }
        if (low >= high){
            return;
        }
        //get the pivot element from the middle of the list
        int middle = low + (high - low) /2;
        int pivot = nums [middle];

        //make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j){
            //check until all values on left side array are lower than pivot
            while (nums[i] < pivot){
                i++;
            }
            //check until all values on the right side array are greater than pivot
            while (nums[j] > pivot){
                j--;
            }
            //compare values from both side of lists to see if they need swapping
            if (i <= j){
                swap(nums, i , j);
                i++;
                j--;
            }
        }
        //do same operation as above recursively to sort two sub array
        if (low < j){
            quickSort(nums, low, j);
        }
        if (high > i){
            quickSort(nums, i, high);
        }
    }


    public static void swap (int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

    }
    public static void main(String[] args){
        int[] nums =new int[] {5, 2, 3, 1};
        Solution912 ns = new Solution912();
        System.out.println(Arrays.toString(ns.sortArray(nums)));
    }
}