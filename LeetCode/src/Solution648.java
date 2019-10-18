import java.util.*;
/**
 * 648. Replace Words
 * https://leetcode.com/problems/replace-words/
 *
 *
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * Example 1:
 *
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 *
 *
 * Note:
 *
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class Solution648 {
    public String replaceWords(List<String> dict, String sentence){
        Set<String> wordSet = new HashSet<>();
        for (String word : dict){
            wordSet.add(word);
        }
        StringBuilder result = new StringBuilder();

        //That regular expression \\s+ simply says: "one or more whitespaces".
        for(String single : sentence.split("\\s+")){
            String prefix = "";
            for (int i = 1; i <= single.length(); i++) {
                prefix = single.substring(0, i); //prefix will be single if not in the wordSet
                if (wordSet.contains(prefix)) { //stop update the prefix if found in the wordSet
                    break;
                }
            }
            if (result.length() > 0) result.append(" ");
            result.append(prefix);
        }

    return result.toString();
    }
    public static void main (String[]args){
        Solution648 ns  =  new Solution648();
        List<String> dict =  new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(ns.replaceWords(dict, sentence));
    }
}
