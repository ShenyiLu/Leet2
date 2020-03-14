package easy;

public class L242IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];
        int[] tChar = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sChar[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tChar[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }
}
