/**
 * Find the maximum diff pairs in an array
 * such as this array: int[] a = {2, 3, 10, 2, 4, 8, 1},
 * find the max difference pair in the array, in the meantime make sure the larger value is at the higher index than the lower value.
 */
public class MaxDifference {
    public int maxdiff (int[] array){
        int minimum, diff = -1;
        if (array.length == 0) return -1;

        minimum = array[0];
        for (int i = 1; i < array.length; i++){
            diff = Math.max (diff, array[i] - minimum);
            minimum = Math.min (minimum, array[i]);
        }
        return diff > 0? diff: -1;

    }
    public static void main (String[] args){
        MaxDifference ns = new MaxDifference();
        System.out.println(ns.maxdiff( new int[]{1, 4, 3, 7, 8, 2, 10}));
    }
}
