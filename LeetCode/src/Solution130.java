import java.util.Arrays;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of
 * the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected
 * to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent
 * cells connected horizontally or vertically.
 *
 *
 */
public class Solution130 {
    /**
     * DFS solution
     * time complexity is O(m*n)
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;//y
        int n = board[0].length;//x
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        // go through the first column j=0 and the last column j=n-1
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // go through the first row and the last row
        for (int j = 1; j < n - 1; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // make all the remaining 'O' to 'X'
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }


    // make every 'O' that we meet to '*', since any O connected to O at the border should not turn into X
    // It is safe because we always start from the border
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'X' || board[i][j] == '*') return;
        board[i][j] = '*'; //make O to *
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public static void main(String[]args){
        Solution130 ns = new Solution130();
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        ns.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
