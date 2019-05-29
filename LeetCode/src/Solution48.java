import java.util.Arrays;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Two Steps:
 * 1. Transpose it symmetrically based on diagonal. swap(matrix[i][j], matrix[j][i])
 *
 * 1 2 3   to  1 4 7
 * 4 5 6   to  2 5 8
 * 7 8 9   to  3 6 9
 *
 * 2. Flip the matrix horizontally (swap(matrix[i][j], matrix[i][matrix.length-1-j])
 *
 * 7 4 1
 * 8 5 2
 * 9 6 3
 *
 */
public class Solution48 {
    public void rotate (int[][] matrix){
        for (int i=0; i<matrix.length; i++){
            //be aware j start at i, otherwise the the matrix will be flip twice(no change)
            for (int j =i; j<matrix[0].length; j++){
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix [i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
    public static void main (String [] args){
        Solution48 ns = new Solution48();
        int[][] matrix = new int [][]{{1,2,3}, {4,5,6}, {7,8,9}};
        ns.rotate(matrix);
        /**Use Arrays.deepToString to print 2D array*/
        System.out.println(Arrays.deepToString(matrix));
    }
}
