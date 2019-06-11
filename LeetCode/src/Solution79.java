/**
 * 79. Word Search
 *  https://leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *------------------------
 * 1. About "board[y][x] ^= 256;"
 * it means when we search the board time and time again, in order to avoid repeat work, we need to mark the searched
 * character, the naive solution is to create another boolean matrix, but it will costs a lot of space, if we do it
 * with bit mask we can make the searched character to a special character, and when we search it again, it will never
 * match any character we met before, which is another way to avoid repeat work. When we finish the search start from
 * board[i][j] this time, in order to prepare for the next round search, we need to revel the mask, recover the
 * character which is masked, so we do board[y][x] ^= 256 again.
 */
public class Solution79 {
    /**
     * DBF Approach
     * Time complexity O(m^2 * n^2)
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();//convert String to char[] Array
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;//when word length are zero return true
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;//check if out of border
        if (board[y][x] != word[i]) return false; //check the content
        board[y][x] ^= 256;// flip the bit to indicate whether the current character is visited, as each character can only be used once
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1); //check the 4 different connection
        board[y][x] ^= 256; //revel the mask, flip the bit back again
        return exist;
    }
}
