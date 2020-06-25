package easy;

public class L278FirstBadVersion {
    public int firstBadVersion(int n) {
        int head = 1;
        int tail = n;
        while (head < tail) {
            int check = head + (tail - head) / 2;
            if (!isBadVersion(check)) {
                head = check + 1;
            } else {
                tail = check;
            }
        }
        return head;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
