package medium;

import java.util.HashMap;
import java.util.Map;

public class L159LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxlen = 0;
        int slowIndex = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for(int fastIndex = 0; fastIndex < s.length(); fastIndex++) {
            char chi = s.charAt(fastIndex);
            countMap.put(chi, countMap.getOrDefault(chi, 0) + 1);
            while(slowIndex <= fastIndex && countMap.size() > 2) {
                char chj = s.charAt(slowIndex);
                if(countMap.get(chj) == 1) {
                    countMap.remove(chj);
                }
                else {
                    countMap.put(chj, countMap.get(chj)-1);
                }
                slowIndex++;
            }
            maxlen = Math.max(maxlen, fastIndex-slowIndex+1);
        }
        return maxlen;

    }


}
