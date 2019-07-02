import javafx.util.Pair;
import java.util.*;

/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 */
public class Solution127 {
    /**
     * Solution 1: BFS
     * Time Complexity: O(M×N), where M is the length of words and N is
     * the total number of words in the input word list.
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //create a Hashset and store the word in the wordList
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);
        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord); //add beginWord into the queue q

        int l = beginWord.length();
        int steps = 0;

        while (!q.isEmpty()) {
            ++steps;
            //s is the size of the current level
            for (int s = q.size(); s > 0; s--) {
                String w = q.poll(); //get the first String from the queue q
                char[] chs = w.toCharArray();//get characters of it to a char[]
                //iterate all the characters in char[], e.g hit -> *it ->h*t ->hi*
                for (int i = 0; i < l; i++) {
                    char ch = chs[i];
                    //try to change the character from a to z
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) continue;//avoid duplicate
                        chs[i] = c; //replace the chs[i] with c ('a' to 'c')
                        String t = new String(chs);
                        if (t.equals(endWord)) return steps + 1; //find the endWord
                        if (!dict.contains(t)) continue; //dict does not contain the String
                        dict.remove(t); //remove t from dict if have it, because it can only be used once
                        q.offer(t); //add it to the end of the queue
                    }
                    chs[i] = ch;//recover the chs[i] so you can change the chs[i] in the next loop
                }
            }
        }
        return 0;
    }

    /**
     * Solution 2: Bidirectional BFS 双向BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);

        if (!dict.contains(endWord)) return 0;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            ++steps;

            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            Set<String> q = new HashSet<>();

            for (String w : q1) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; i++) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String t = new String(chs);
                        if (q2.contains(t)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }

            q1 = q;
        }
        return 0;
    }

    public static void main(String[]args){
        Solution127 ns = new Solution127();
        List<String> wordList =Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ns.ladderLength("hit" ,"cog", wordList));

    }
}
