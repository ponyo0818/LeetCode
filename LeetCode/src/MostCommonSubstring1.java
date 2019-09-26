/**
 *
 * We have a string of length N. Can you figure out the number of occurrences of the most frequent substring in this string?
 * We are only interested in substring of length from K to L and in each substring the number of distinct characters must not exceed M.
 * The string contains only lower-case letters(a-z).
 * Constraints:
 * 2<=N<=100000
 * 2<=K<=L<=26,L<N
 * 2<=M<=26
 *
 * Sample Input :-
 * 5
 * 2 4 26 // value of K L M
 * abcde
 * 
 * Sample Output :-
 * 1
 * http://rootchutney.blogspot.com/2016/07/most-often-substring-most-common.html
 */

import java.util.*;

public class MostCommonSubstring1 {
    TrieNode root;
    Set distinctCharacters = new HashSet();

    public int getHighestFrequencyOfSubstring(int n, int k, int l, int m, String s) {
        if (s == null || n == 0) {
            return 0;
        }
        if (k < 0 || l < 0 || m <= 0) {
            return 0;
        }
        int maxFrequency = 1;
        root = new TrieNode();
        for (int i = 0; i < n; ++i) {
            for (int j = k; j <= l && j <= n; ++j) {
                String substring = s.substring(i,j);
                // return -1 if distincts more than m
                int currentFrequency = insertIntoTrie(substring, m);
                if (currentFrequency == -1)
                    break;
                maxFrequency = (currentFrequency > maxFrequency) ? currentFrequency : maxFrequency;
            }
            k += 1;
            l += 1;
        }
        return maxFrequency;
    }

    public int insertIntoTrie(String word, int m) {
        distinctCharacters.clear();
        TrieNode parent = root;
        for(char c : word.toCharArray()) {
            distinctCharacters.add(c);
            if (distinctCharacters.size() > m) {
                return -1;
            }
            int i = c - 'a';
            if(parent.next[i] == null)
                parent.next[i] = new TrieNode();
            parent = parent.next[i];
        }
        if (parent.word != null) {
            parent.frequency += 1;
        } else {
            parent.word = word;
            parent.frequency = 1;
        }
        return parent.frequency;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
        int frequency = 0;
    }

    public static void main (String [] args){
        MostCommonSubstring1 ns = new MostCommonSubstring1();
        String newString = "abcde";
        System.out.println(ns. getHighestFrequencyOfSubstring(5, 2, 4, 26 , newString));
    }
}
