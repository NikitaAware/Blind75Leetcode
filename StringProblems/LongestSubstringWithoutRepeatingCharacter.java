package StringProblems;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> pos = new HashMap<Character, Integer>();
        int res = 0;
        int start = 0;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if (pos.containsKey(s.charAt(i)) && pos.get(s.charAt(i)) >= start) { // present and included in the string
               res = Math.max(res, i - start);
               start = pos.get(s.charAt(i)) + 1; // start with the position just after the repetetion
            } 
            pos.put(s.charAt(i), i);
        }
        res = Math.max(res, i - start); // if longest ends at s.length() - 1
        return res;
    }
    public void printLongestSubstringWithoutRepeatingCharacter(String s) {
        System.out.println(lengthOfLongestSubstring(s));
    }
}
