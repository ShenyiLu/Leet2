package medium;

import java.util.ArrayList;
import java.util.List;

public class L320GenerateAbbreviations {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        if (word.length() == 0) {
            result.add("");
            return result;
        }
        getAbbr(word, 0, "", 0, result);
        return result;
    }

    private void getAbbr(String word, int index, String current, int count, List<String> result) {
        if (index == word.length()) {
            if (count > 0) {
                current += count;
            }
            result.add(current);
        } else {
            getAbbr(word, index + 1, current, count + 1, result);
            getAbbr(word, index + 1, current + (count > 0 ? count : "") + word.charAt(index), 0, result);
        }
    }
}
