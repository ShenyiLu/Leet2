package medium;

public class L211WordDictionary {
    private wordNode dummyNode;

    /**
     * Initialize your data structure here.
     */
    public L211WordDictionary() {
        dummyNode = new wordNode('.');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        char[] wordArray = word.toCharArray();
        dummyNode.addWord(wordArray, 0);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
        return dummyNode.dfs(wordArray, 0);
    }

    private class wordNode {
        private char local;
        private boolean isLast;
        private wordNode[] wordNodes;

        public wordNode(char c) {
            local = c;
            isLast = false;
            wordNodes = new wordNode[26];
            for (int i = 0; i < wordNodes.length; i++) {
                wordNodes[i] = null;
            }
        }

        public void addWord(char[] wordArray, int index) {
            if (index == wordArray.length) {
                isLast = true;
                return;
            }
            char keyChar = wordArray[index];
            if (wordNodes[keyChar - 'a'] == null) {
                wordNodes[keyChar - 'a'] = new wordNode(keyChar);
            }

            wordNodes[keyChar - 'a'].addWord(wordArray, index + 1);
        }

        // key should not contain first char
        public boolean dfs(char[] wordArray, int index) {
            if (index == wordArray.length) {
                return isLast;
            }
            char keyChar = wordArray[index];
            if (index == wordArray.length - 1) {
                if (wordArray[index] == '.') {
                    for (wordNode node : wordNodes) {
                        if (node != null && node.dfs(wordArray, index + 1)) {
                            return true;
                        }
                    }
                    return false;
                }


                if (wordNodes[keyChar - 'a'] == null) {
                    return false;
                } else {
                    return wordNodes[keyChar - 'a'].dfs(wordArray, index + 1);
                }
            }

            if (keyChar == '.') {
                for (int i = 0; i < wordNodes.length; i++) {
                    if (wordNodes[i] != null && wordNodes[i].dfs(wordArray, index + 1)) {
                        return true;
                    }
                }
            } else {

                if (wordNodes[keyChar - 'a'] == null) {
                    return false;
                } else {
                    return wordNodes[keyChar - 'a'].dfs(wordArray, index + 1);
                }
            }
            return false;
        }
    }


}
