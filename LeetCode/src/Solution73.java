import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *--------------------
 * 1. In-space
 * an in-place algorithm is an algorithm which transforms input using no auxiliary data structure.
 */
public class Solution73 {
    /**
     * Time Complexity : O(M×N)
     * Space Complexity : O(1)
     * @param matrix
     *
     *      j-column
     *        1 1 1
     * i-row  1 1 1
     *        1 1 0
     *
     * The key of the solution is to iterate over the matrix from second row and second column, check [i][j] and marked
     * [i][0] and [j][0] to zero once found 0, and use this as reference to set cells to 0 accordingly,However, if there
     * are 0 originally in the first row and column, this would not set the first row or column to 0. Therefore, create
     * two booleans to record if there are 0 in the first row or column, and then mark all cell in first row/column to 0
     * separately.
     */
    public void setZeroes(int[][] matrix){
        boolean isZeroCol = false;
        boolean isZeroRow = false;
        //check the first column [i][0]
        for (int i =0; i<matrix.length;i++){
            if(matrix[i][0] == 0){
                isZeroCol = true;
                break;
            }
        }

        //check the first row [0][j]
        for (int j =0; j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                isZeroRow = true;
                break;
            }
        }

        //check expect the first row and column, once 0 found, set matrix[i][0] and matrix[0][j] to 0;
        for (int i=1; i < matrix.length;i++){
            for (int j=1; j< matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Process expect the first row and column, note that it did all the work except first row/column
        for (int i=1; i<matrix.length;i++){
            for (int j=1; j<matrix[0].length;j++){
                if(matrix[i][0] == 0||matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }
        //handle the first column, set the first column to 0
        if (isZeroCol) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
        //handle the first row, set the first row to 0
        if (isZeroRow) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }

    }
    public static void main(String[] args){
        Solution73 ns = new Solution73();
        int[][] matrix = new int[][]{
                {1,0,1,1,1},
                {1,1,1,0,1},
                {1,1,1,1,1},
                {1,0,1,1,1}
        };
        ns.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
