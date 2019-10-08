import java.util.*;
import java.util.HashSet;

/**
 * Remove the duplicate letters in a string
 */

public class RemoveDuplicates {
    /**
     * List<String> and Hashset<String>
     * Use String.join(delimiter, list)
     * @param s
     * @return
     */
    public String removeDuplicates(String s){
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i =0; i<s.length(); i++){

            String letter  = Character.toString(s.charAt(i));
            if(!hs.contains(letter)){
                hs.add(letter);
                list.add(letter);
            }
        }
        String result = String.join("", list);
        return result;
    }

    /**
     *List<Character> and Hashset<Character>
     * Use StringBuilder
     * @param s
     * @return
     */
    public String removeDuplicates2(String s){
        HashSet<Character> hs = new HashSet<>();
        ArrayList<Character> list = new ArrayList<>();
        for (char c: s.toCharArray()){
            if(!hs.contains(c)){
                hs.add(c);
                list.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: list){
            sb.append(c);
        }
        String result = sb.toString();
        return result;
    }
    public static void main (String[]args){
        RemoveDuplicates ns = new RemoveDuplicates();
        String s = "aabbccddee";
        System.out.println(ns.removeDuplicates2(s));
    }
}
