import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Layer-by-Layer Approach
 * all the elements in clockwise order from the first-outer layer, followed by the elements from the second-outer
 * layer, and so on
 *
 * -----------
 * LinkedList implements it with a doubly-linked list. ArrayList implements it with a dynamically resizing array.
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix){
        //initial a new linked list for result
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length ==0) return res;
        int n = matrix.length, m = matrix[0].length; //as n is row length, m is the column length
        //set row begin, row end, column begin, column end
        /**
         *  left      right
         *  1 1 1 1 1 1  up
         *  1 2 2 2 2 1
         *  1 2 3 3 2 1
         *  1 2 2 2 2 1
         *  1 1 1 1 1 1  down
         */
        int up=0, down = n-1, left=0, right = m-1;
        while (res.size() < n*m){ //the conditions to check borders are all the same
            //go right
            for (int j=left; j<=right && res.size()<n*m; j++)
                res.add(matrix[up][j]);
            //go down
            for (int i=up+1; i<=down-1 && res.size()<n*m; i++)
                res.add(matrix[i][right]);
            //go left
            for (int j=right; j>=left && res.size()<n*m; j--)
                res.add(matrix[down][j]);
            //go up
            for (int i=down-1; i>=up+1 && res.size()<n*m; i--)
                res.add(matrix[i][left]);

            left++; down--; up++; right--;
        }
        return res;
    }
    public static void main (String [] args){
        Solution54 ns = new Solution54();
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(ns.spiralOrder(matrix));
    }
}
