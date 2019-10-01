import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 *  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 */

public class Solution387 {
    /**
     * Get the frequency of each character.
     * Get the first character that has a frequency of one.
     * takes O(n) and goes through the string twice
     * @param s
     * @return
     */
    public int firstUniqChar1(String s){
        int [] count = new int[256];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++){
            if (count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * O(n) solution with Map
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        if(s==null || s.length()==0)
            return -1;
        Map<Character, Integer> charToC = new HashMap();
        for(char ch : s.toCharArray()) {
            charToC.put(ch, charToC.getOrDefault(ch, 0)+1);
            //The getOrDefault() method returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
        }
        for(int i=0; i<s.length(); i++){
            if(charToC.get(s.charAt(i)) ==1){
                return i;
            }
        }
        return -1;
    }

}
