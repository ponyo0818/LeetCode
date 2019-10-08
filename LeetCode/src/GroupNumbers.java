import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * input n
 * 1 1 1 0 1 1 0
 * to
 * 1 1 1 1 1 0 0 dec
 * or
 * 0 0 1 1 1 1 1 asc
 * return the minMove to group the same value together
 */

public class GroupNumbers {
    public int minMove(int[] input){
        int[] sortedArr = input.clone();
        Arrays.sort(sortedArr); //ascending
        int result = calculateMove(input, sortedArr, 1, 0);


        //primitive value is unable to use Arrays.sort(arr, collections.reverseOrder())
        int[] DecSortedArr = new int [input.length];
        int j = input.length -1;
        for (int i =0; i < sortedArr.length; i++){
            DecSortedArr[j--] = Integer.valueOf(sortedArr[i]);
        }
        //System.out.println(result + "ascending" + Arrays.toString(sortedArr) + "descending:" + Arrays.toString(DecSortedArr));
        result = Math.min(result, calculateMove(input, DecSortedArr, 1, 0));
        return result;
    }
    public int calculateMove(int[] inputArr, int[] sortedArr, int value1, int value2){
        ArrayList<Integer> value1to2 = new ArrayList<>();
        ArrayList<Integer> value2to1 = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < inputArr.length;i++){
            if (inputArr[i] == value1 && sortedArr[i] == value2){
                value1to2.add(i);
            }
            if (inputArr[i] == value2 && sortedArr[i] == value1){
                value2to1.add(i);
            }
        }
        for (int i = 0; i < value1to2.size(); i++){
            result += Math.abs(value1to2.get(i) - value2to1.get(i));
        }
        return result;
    }

    public static void main (String[]args){
        GroupNumbers ns = new GroupNumbers();
        //int[] input = new int[]{1, 0 ,1 ,0 ,0 ,0 ,0 ,1};
        int[] input = new int[]{1, 1, 1, 1, 0, 1, 0, 1};
        System.out.println(ns.minMove(input));
    }
}
