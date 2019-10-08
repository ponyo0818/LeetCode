import java.util.stream.*;

/**
 * Here magic = [8, 4, 1, 9] and dist = [10, 9, 3, 5]. In each case, the distance to the next source is greater
 * than the amount of magic at the current source.  No matter where Aladdin starts, he will not be able to
 * finish his travel.
 * Here magic = [2, 4, 5, 2] and dist = [4, 3, 1, 3].
 * accumulate [-2, 1, 4, -1]
 * Complete the function optimalPoint in the editor below. The function must return an integer that denotes
 * the minimum index of magic from which he can start a successful journey. If no such starting point exists,
 * return -1.
 *
 * This is similar with the GasStation problem
 *
 */

public class OptimalPoint {
    public int optimalPoint(int[] magic, int[] dist){
        int sumMagic = IntStream.of(magic).sum();
        int sumDist = IntStream.of(dist).sum();
        if (sumMagic < sumDist) return -1;
        int [] accumulate = new int[magic.length];
        for (int i =0; i < magic.length; i++){
            accumulate[i] = magic[i] - dist[i];
        }
        int energy = accumulate[0];
        int result = 0;
        for (int i =1; i < accumulate.length; i++){
            if (energy < 0){
                result = i;
                energy = 0;
            }
            energy += accumulate[i];
        }
        return result;
    }
    public static void main (String[]args){
        OptimalPoint ns = new OptimalPoint();
        int[] magic = new int[] {2, 4, 5, 2};
        int[] dist = new int[] {4, 3, 1, 3};
        System.out.println(ns.optimalPoint(magic, dist));
    }
}
