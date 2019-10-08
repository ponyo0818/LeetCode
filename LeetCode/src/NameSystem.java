import java.util.*;

/**
 * IBM technical interview
 * Create a name system and deal with the reduplicates name
 */

public class NameSystem {
    public List<String> removeDuplicates (List<String> input){
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String s: input){
            if (!hm.containsKey(s)){
                hm.put(s, 1);
                result.add(s);
            }
            else{
                //update hm
                String name = s + hm.get(s);
                hm.put(s, hm.getOrDefault(s, 0)+1);
                //add the new name to the list
                result.add(name);
            }
        }
        return result;

    }

    public static void main (String[]args){
        List<String> input = new ArrayList<String>();
        input.add("yuan");
        input.add("yuan");
        input.add("yara");
        NameSystem ns = new NameSystem();
        System.out.println(ns.removeDuplicates(input));
    }
}
