import java.util.Arrays;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
 * 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class Solution75 {
    /**
     * One pass in place solution
     * Time complexity O(n)
     * Space complexity O(1)
     * @param A
     */
    public void sortColors(int[] A){
        if(A==null||A.length<2) return;
        int low = 0;
        int high = A.length-1;

        for (int i=low; i<=high;){
            if(A[i]==0){
                //swap A[i] and A[low]; i,low both ++
                int temp = A[i];
                A[i] = A[low];
                A[low] = temp;
                i++;
                low++;
            }
            else if(A[i] ==2){
                //swap A[i] and A[high]; high --(not i++ because need to check A[high])
                int temp = A[i];
                A[i] = A[high];
                A[high] = temp;
                high--;
            }
            else{
                //the A[i]==1, no swap and i++
                i++;
            }
        }
    }

    /**
     * A mind blowing approach (One pass)
     * @param A
     * @param n
     */
    public void sortColors2(int A[], int n) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            //once insert a 0, the 1 was override,so need to move the other numbers forward 1
            //0 0 1 2 ->
            //0 0 0 1 2
            if (A[i] == 0) {
                A[++n2] = 2;
                A[++n1] = 1;
                A[++n0] = 0;
            } else if (A[i] == 1) {
                A[++n2] = 2;
                A[++n1] = 1;
            } else if (A[i] == 2) {
                A[++n2] = 2;
            }
        }
    }
    public static void main (String [] args){
        Solution75 ns =new Solution75();
        int[] A = new int [] {1, 0, 1, 2, 0, 1};
        ns.sortColors(A);
        System.out.println(Arrays.toString(A));
    }

}
