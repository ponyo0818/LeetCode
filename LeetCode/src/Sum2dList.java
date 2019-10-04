import java.util.*;

/**
 * give int[][] arr = {{1,0,1} ,{0,1,1}, {0,1,1}}
 * return int[] result = {{1,2,3}}
 * Workiva interview question
 */

public class Sum2dList {
    public int[] sum2dList (int[][] input){
        int sum1 =0, sum2 = 0, sum3 =0;
        for (int[] arr: input){
            sum1 += arr[0];
            sum2 += arr[1];
            sum3 += arr[2];
        }
        return new int[] {sum1, sum2, sum3};
    }
    public static void main(String[]args){
        int[][] input = {{1,0,1} ,{0,1,1}, {0,1,1}};
        Sum2dList ns = new Sum2dList();
        System.out.println(Arrays.toString(ns.sum2dList(input)));
    }
}
