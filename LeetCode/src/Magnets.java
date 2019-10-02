import java.util.HashMap;

/**
 * you have packs of magnets containing letters "wpengine"
 * write a function that takes in a word (String) and returns an interger indicating the number of packs of magnets you need to spell
 *
 */
public class Magnets {
    public int magnets(String word){
        HashMap<Character, Integer> wordMap = new HashMap<>();
        HashMap<Character, Integer> magnetMap = new HashMap<>();

        String magnet = "wpengine";
        for (int i = 0; i< magnet.length(); i++){
            char c = magnet.charAt(i);
            magnetMap.put(c, magnetMap.getOrDefault(c, 0)+1);
        }

        for (int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            wordMap.put(c, wordMap.getOrDefault(c, 0)+1);
        }

        //get the number of packs of magnets
        int result = 0;
        for (char c: wordMap.keySet()){
            if (!magnetMap.containsKey(c)) return -1;
            result = Math.max(result, (int)Math.ceil((double)wordMap.get(c)/(double)magnetMap.get(c)));
            //System.out.println((double)wordMap.get(c)+ ","+ (double)magnetMap.get(c));
        }
        return result;
    }

    public static void main(String[]args){
        Magnets ns = new Magnets();
        //String s = "winwin";
        //String s = "winn";
        String s = " ";
        System.out.println(ns.magnets(s));
    }
}
