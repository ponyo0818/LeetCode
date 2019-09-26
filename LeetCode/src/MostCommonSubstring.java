/** BUG UNFIXED*/
import java.util.Collections;
import java.util.HashMap;

public class MostCommonSubstring {
    public static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique){
        HashMap <String, Integer> hash =new HashMap<String, Integer> ();
        for (int i = 0; i< s.length(); i++){
            int maxIndex;
            if(minLength < s.length() -i){
                maxIndex = minLength;
            }
            else{
                maxIndex = s.length() -1;
            }

            for (int j = minLength; j<= maxIndex; j++){
                String sub = s.substring(i, j);
                int distinctChar = countUniqueChar(sub);
                if(sub.length() >= minLength && s.length() <= maxLength && distinctChar <= maxUnique){
                    if (hash.containsKey(sub)){
                        int newValue = hash.get(sub) + 1;
                        System.out.println(newValue);
                        hash.replace (sub, newValue);
                    }
                    else hash.put(sub, 1);
                }
            }
        }
        return Collections.max(hash.values());

    }
    public static int countUniqueChar(String input){
        boolean [] haveSeen = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < input.length(); i++){
            haveSeen[input.charAt(i)] = true; //value of the char
        }
        int count = 0;
        for (int i = 0; i < haveSeen.length; i++){
            if(haveSeen[i] == true){
                count++;
            }
        }
        return count;
    }

    public static void main (String [] args){
        MostCommonSubstring ns = new MostCommonSubstring();
        String newString = "abcde";
        System.out.println(ns. getMaxOccurrences(newString, 2, 4, 26));
    }
}
