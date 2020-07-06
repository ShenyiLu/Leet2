package hard;

import java.util.ArrayList;
import java.util.List;

public class L68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> currentLine = new ArrayList<>();
        List<String> result = new ArrayList<>();

        String currentWord = words[0];
        currentLine.add(currentWord);
        int index = 1;
        int currentLineWidth = currentWord.length();

        while (index < words.length) {
            currentWord = words[index++];
            int currentWordLength = currentWord.length();
            // check if we can add a word to current line
            if (currentLineWidth + 1 + currentWordLength <= maxWidth) {
                currentLine.add(currentWord);
                currentLineWidth += 1 + currentWordLength;
            } else {
                // parse current line into string
                if (currentLine.size() == 1) {
                    result.add(leftJustified(currentLine, maxWidth));
                } else {
                    result.add(fullyJustified(currentLine, maxWidth));
                }

                // start next line
                currentLine.clear();
                currentLine.add(currentWord);
                currentLineWidth = currentWordLength;
            }
        }

        // handle last line here
        result.add(leftJustified(currentLine, maxWidth));
        return result;
    }

    //    private String fullyJustified(List<String> currentLine,List<Integer> currentLineWordLength, int maxWidth) {
    private String fullyJustified(List<String> currentLine, int maxWidth) {

        if (currentLine.get(0).length() == maxWidth) {
            return currentLine.get(0);
        }

        StringBuilder builder = new StringBuilder();
        int insertBlankStrCount = currentLine.size() - 1;
        int insertBlankCharCount = maxWidth;
        for (String word : currentLine) {
            insertBlankCharCount -= word.length();
        }

        String[] insertBlank = new String[insertBlankStrCount];
        for (int i = 0; i < insertBlank.length; i++) {
            insertBlank[i] = "";
        }

        int insertBlankIndex = 0;
        while (insertBlankCharCount > 0) {
            insertBlank[insertBlankIndex++] += " ";
            insertBlankIndex = (insertBlankIndex >= insertBlank.length ? 0 : insertBlankIndex);
            insertBlankCharCount--;
        }

        for (int i = 0; i < insertBlank.length; i++) {
            builder.append(currentLine.get(i));
            builder.append(insertBlank[i]);
        }
        builder.append(currentLine.get(currentLine.size() - 1));
        String result = builder.toString();
        builder.setLength(0);
        return result;
    }

    private String leftJustified(List<String> currentLine, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        builder.append(currentLine.get(index));
        int currentWidth = currentLine.get(index).length();
        index++;
        while (index < currentLine.size()) {
            builder.append(" ");
            builder.append(currentLine.get(index));
            currentWidth += 1 + currentLine.get(index).length();
            index++;
        }

        while (currentWidth < maxWidth) {
            builder.append(" ");
            currentWidth++;
        }
        return builder.toString();
    }
}
