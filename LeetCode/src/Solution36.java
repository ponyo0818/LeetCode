/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 *
 * -------------------
 * java.util.HashSet.add() Method
 *
 * The add(E e) method is used to add the specified element to this set if it is not already present.
 * If this set already contains the element, the call leaves the set unchanged and returns false.
 *
 * HashSet is implementation of Set Interface which does not allow duplicate value!!add()
 * HashMap does not allow duplicate keys!! put()
 *
 * THE MOST TRICKY PART:
 * How to traverse each sub cubes (3*3)?
 *
 * RowIndex:
 *
 *
 * as j: 0, 1, 2, 3, 4, 5, 6, 7, 8
 *   i : 0, 1, 2, 3, 4, 5, 6, 7, 8
 *
 * j/3:  0, 0, 0, 1, 1, 1, 2, 2, 2 |use for vertical traversal
 *
 * j%3:  0, 1, 2, 0, 1, 2, 0, 1, 2 |use for horizontal traversal
 *
 * So while
 */
import java.util.*;

public class Solution36 {
    public boolean isValidSudoku(char [][] board){
        for (int i=0; i<9; i++){
            //Create Hashsets for rows, columns and sub cubes (3*3), reset them in every loop
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            //First, i j stands for normal coordinate of board itself
            //Travers each column and rows, return false if value is already exist in the Hashset
            for (int j=0; j<9; j++){
                if(board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;

                //精彩的表演开始了
                //Use / for vertical traversal. Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1
                //to move to next block vertically.
                //0, 0, 0, 3, 3, 3, 6, 6 ,6
                int RowIndex = 3* (i/3);
                //Use % for horizontal traversal. Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2,
                // and resets back. So this covers horizontal traversal for each block by 3 steps.
                // to increment block, use i. To move horizontally to next block, use % again : ColIndex = 3 * i%3
                // (Multiply by 3 so that the next block is after 3 columns. Ie 0,0 is start of first block, second block is 0,3 (not 0,1)
                // 0, 3, 6, 0, 3, 6, 0, 3, 6
                int ColIndex = 3* (i%3);
                //vertical only move down 1 after, horizontal move 3 to the right
                if (board[RowIndex + j/3][ColIndex +j%3]!='.' && !cube.add(board[RowIndex + j/3] [ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
    public static void main (String [] args){
        Solution36 newSolution = new Solution36();
        //use '' for char, " " for string
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(newSolution.isValidSudoku(board));
    }
}
