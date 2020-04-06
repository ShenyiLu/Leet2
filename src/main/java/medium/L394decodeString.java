package medium;

import java.util.Stack;

public class L394decodeString {
    public String decodeString(String s) {
        return recursive(s, 0, s.length() - 1);
    }

    public String recursive(String s, int head, int tail) {
        String sub = s.substring(head, tail + 1);
        if (!sub.contains("[")) {
            return sub;
        }

        Stack<Character> stack = new Stack<>();
        int num = 0;
        int localHead = 0;
        int localTail = 0;
        String result = "";


        for (int i = head; i <= tail; i++) {
            char c = s.charAt(i);
            if (stack.size() == 0 && 'a' <= c && c <= 'z') {
                result += c;
            }


            if ('0' <= c && c <= '9' && stack.size() == 0) {
                num = num * 10 + (c - '0');
            }
            if (c == '[') {
                if (stack.size() == 0) {
                    localHead = i + 1;
                }
                stack.push(c);
            }
            if (c == ']') {
                if (stack.size() == 1) {
                    localTail = i - 1;
                    String localResult = recursive(s, localHead, localTail);
                    for (int j = 0; j < num; j++) {
                        result += localResult;
                    }
                    num = 0;
                }
                stack.pop();
            }
        }
        return result;
    }
}
