package medium;

public class L621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int maxTaskLength = 0;
        int maxTaskCount = 0;
        int[] charCount = new int[26];
        for (char c : tasks) {
            charCount[c - 'A']++;
        }
        for (int i : charCount) {
            if (i == maxTaskLength) {
                maxTaskCount++;
            } else if (i > maxTaskLength) {
                maxTaskLength = i;
                maxTaskCount = 1;
            }
        }
        // calculate what will happen
        return Math.max((maxTaskLength - 1) * (n + 1) + maxTaskCount, tasks.length);
    }
}
