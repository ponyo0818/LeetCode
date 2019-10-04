import java.util.*;

/**
 * meandering sort an array to [first_largest, first_smallest, second_largest, second_smallest]
 */
public class meanderingArray {
    public ArrayList<Integer> meanderingSort(ArrayList<Integer> input){
        Collections.sort(input);
        ArrayList<Integer> output = new ArrayList<>();
        int start = 0;
        int end = input.size()-1;

        while (start < end){
            output.add(input.get(end));
            output.add(input.get(start));
            start++;
            end --;
        }
        if (start == end){
            output.add(input.get(end));
        }
        return output;
    }

    public static void main(String[]args){
        meanderingArray ns = new meanderingArray();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, -1, -2, -3));
        System.out.println(ns.meanderingSort(input));
    }
}
