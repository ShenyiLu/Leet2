package easy;


public class L392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        boolean[] charExistInS = new boolean[26];
        boolean[] charExistInT = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charExistInS[ch - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (charExistInS[ch - 'a']) {
                builder.append(ch);
                charExistInT[ch - 'a'] = true;
            }
        }
        if (builder.length() < s.length()) {
            return false;
        }

        for (int i = 0; i < charExistInS.length; i++) {
            if (charExistInS[i] != charExistInT[i]) {
                return false;
            }
        }

        String tShort = builder.toString();
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < tShort.length()) {
            char sChar = s.charAt(sIndex);
            while (tIndex < tShort.length() && tShort.charAt(tIndex) != sChar) {
                tIndex++;
            }
            if (tIndex == tShort.length()) {
                return false;
            }
            sIndex++;
        }
        return true;
    }


}
