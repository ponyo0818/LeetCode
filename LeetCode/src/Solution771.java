import java.util.HashSet;


/**
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Java String toCharArray()
 * string toCharArray() method converts the given string into a sequence of characters.
 * The returned array length is equal to the length of the string.
 */
public class Solution771 {
    public int numJewelsInStone(String J, String S){
        int res = 0;
        HashSet<Character> setJ= new HashSet<Character>();
        for (char j : J.toCharArray()) {
            setJ.add(j);
        }
        for (char s: S.toCharArray()) {
            if (setJ.contains(s)) res++;
        }
        return res;
    }
    public static void main (String [] args) {
        Solution771 ns = new Solution771();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(ns.numJewelsInStone(jewels, stones));
    }
}
