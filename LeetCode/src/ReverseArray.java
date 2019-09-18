import java.util.Arrays;

/**
 * Amazon OA
 */
public class ReverseArray {
    public int[] reverse(int a[]){
        int len = a.length;
        int [] result = new int [len];
        int j = len;

        for (int i =0; i < len; i++) {
            result[j - 1] = a[i];
            j--;
        }
        return result;
    }
    public static void main (String[]args){
        int [] a = {1,2,3,4,5};
        ReverseArray ra = new ReverseArray();
        System.out.println(Arrays.toString(ra.reverse(a)));
    }
}
