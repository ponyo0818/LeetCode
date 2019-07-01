import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * -----------------
 * The ArrayList.set() method is used to set an element in an ArrayList object at the specified index.
 */
public class Solution118 {
    /**
     * [1] -add 1 at the start -> [1,1] no update
     * ->[1,1,1], only update the 1 in the middle to [1,2,1]
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int level=0; level<numRows;level++){
            row.add(0,1);
            for (int j=1; j<row.size()-1;j++)
                row.set(j,row.get(j)+row.get(j+1));
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
    public static void main(String[]args){
        Solution118 ns =new Solution118();
        System.out.println(ns.generate(5));
    }

}
