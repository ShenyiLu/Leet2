package medium;

public class L186ReverseWords {
    public void reverseWords(char[] s) {
        if (s.length <= 1) {
            return;
        }

        reverse(s, 0, s.length - 1);

        int head = 0;
        int tail = 1;
        while (tail < s.length) {
            while (tail < s.length && s[tail] != ' ') {
                tail++;
            }
            reverse(s, head, tail);
            head = ++tail;
        }
    }

    private void reverse (char[] s, int head, int tail) {
        if (head == tail) {
            return;
        }
        while (head < tail) {
            char temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;

            head++;
            tail--;
        }
    }
}
