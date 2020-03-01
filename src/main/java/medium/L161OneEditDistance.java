package medium;

public class L161OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength + 1 == tLength) {
            return tryInsert(s, t);
        }

        if (sLength - 1 == tLength) {
            return tryDelete(s, t);
        }

        if (sLength == tLength) {
            return tryReplace(s, t);
        }

        return false;
    }

    private boolean tryInsert(String s, String t){
        if (s.length() == 0 && t.length() == 1) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;
        int count = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) != t.charAt(tIndex)) {
                return s.substring(sIndex).equals(t.substring(tIndex + 1));
            }
            sIndex++;
            tIndex++;
        }

        return true;
    }

    private boolean tryDelete(String s, String t){
        if (s.length() == 1 && t.length() == 0) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;
        int count = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) != t.charAt(tIndex)) {
                return s.substring(sIndex + 1).equals(t.substring(tIndex));
            }
            sIndex++;
            tIndex++;
        }
        return true;
    }

    private boolean tryReplace(String s, String t){
        if (s.length() == 1 && t.length() == 1) {
            return s.charAt(0) != t.charAt(0);
        }
        if (s.length() == 0 && t.length() == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }
        return count == 1;
    }
}
