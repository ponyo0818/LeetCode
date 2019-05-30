import java.lang.reflect.Array;
import java.util.*;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *  Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], (an array)
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * The key of this question is sorted anagrams are the same
 * Use Hashmap to store anagrams (list<String>) and sorted anagrams as the key (String)
 *
 * ----------
 * 1. allow you to add new values to any list that is contained as a value in the map
 * map.get(listKey).add(newValue);
 *
 * 2. return an empty ArrayList:
 * just do: return new ArrayList<Type>()
 * ArrayList<Type> str = new ArrayList<Type>()
 *
 * 3. valueOf(char[] data) − Returns the string representation of the char array argument.
 *
 * 4. Convert a Map to List:
 * List<Value> list = new ArrayList<Value>(map.values());
 * assuming: Map<Key,Value> map;
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs){
        if (strs == null|| strs.length == 0) return new ArrayList<List<String>>();
        //Create an Hashmap: Key:sorted string, Value: anagrams
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: strs){
            //store each chars in s(String) in an array
            char[] charInString = s.toCharArray();
            Arrays.sort(charInString);//sort the chars
            String keyStr = String.valueOf(charInString);//convert array<char> back to String
            //if the key not exist in the map, create a node: keyStr is the key, and a new ArrayList is the value
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            //if the key exist in the map, add the String into the corresponding ArrayList
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());//return the values of the map
    }

    public static void main (String [] args){
        Solution49 ns = new Solution49();
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ns.groupAnagrams(strs));
    }
}
