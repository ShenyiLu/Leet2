package easy;

public class L443StringCompression {
    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return 1;
        }
        int slowIndex = 0;
        int fastIndex = 0;
        int compressionIndex = 0;
        while (slowIndex < chars.length) {
            char slowChar = chars[slowIndex];
            int count = 0;
            while (fastIndex < chars.length && chars[fastIndex] == slowChar) {
                fastIndex++;
                count++;
            }
            chars[compressionIndex] = slowChar;
            compressionIndex++;
            if (count > 1) {
                String str = "" + count;
                for (int i = 0; i < str.length(); i++) {
                    chars[compressionIndex++] = str.charAt(i);
                }
            }

            slowIndex = fastIndex;
        }
        return compressionIndex;
    }
}
