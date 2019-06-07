import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 *
 * -------------
 * 1. Array sort
 * Array.sort(arr)
 * Array.sort(arr,1,5) //sort subarray from index 1 to 4
 * Array.sort(arr, Collections.reverseOrder())//sort in descending order
 * //sort array with lambda expression
 * Arrays.sort(arr, (a,b) -> a[0]-b[0])
 *
 * 2. ArrayList to Array conversion
 * result.toArray(new int[result.size()][])
 *
 * 3. Add array to ArrayList()
 * List<int[]> list = new ArrayList<>();
 * list.add(new int[]{1, 2, 3});
 *
 * 3.
 * (1) List<?> myList = new ArrayList<?>();
 * (2) ArrayList<?> myList = new ArrayList<?>();
 * (1) is preferred over the second one. The first has the advantage that the implementation of the List
 *  can change (to a LinkedList for example), without affecting the rest of the code.
 */

public class Solution56 {
    /**
     * Time complexity : O(nlogn) which is dominated by sort
     * Space complexity : O(1) or O(n)
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals){
        if (intervals.length<=1) return intervals;
        //Sort the intervals by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> i1[0]- i2[0]);

        //create an new ArrayList to store the result
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] interval:intervals){
            /**
             * e.g. [1,3][2,4]  or [1,3][2,2]
             * we take the first interval and compare its end with the next intervals starts.
             * if the next start is less than the end of current one, the overlap exist, update
             * the new end with the max end, in the next loop, compare the [start,updated end] with
             * the next
             */
            if(interval[0] <= end)
                end = Math.max(end, interval[1]);
            //Disjoint intervals, end comparing temp with the next, set the current to temp, add the temp to the ArrayList
            else{
                result.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[]{start,end});//add the last one
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args){
        Solution56 ns = new Solution56();
        int[][] intervals = new int [][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(ns.merge(intervals)));
    }
}
