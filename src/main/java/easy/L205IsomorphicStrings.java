package easy;

import java.util.HashMap;

public class L205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMapToT = new HashMap<>();
        HashMap<Character, Character> tMapToS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);


            if (sMapToT.containsKey(sChar) && sMapToT.get(sChar) != tChar) {
                return false;
            } else {
                sMapToT.put(sChar, tChar);
            }

            if (tMapToS.containsKey(tChar) && tMapToS.get(tChar) != sChar) {
                return false;
            } else {
                tMapToS.put(tChar, sChar);
            }
        }
        return true;
    }
}
