package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L937ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String[]> letterLogs = new ArrayList<>();
        int digitLogIndex = logs.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            String log = logs[i];
            String[] split = log.split(" ", 2);
            if (isDigitLog(split)) {
                logs[digitLogIndex] = log;
                digitLogIndex--;
            } else {
                letterLogs.add(split);
            }
        }
        Collections.sort(letterLogs, new LetterLogsComparator());
        int index = 0;
        for (String[] letterLog : letterLogs) {
            logs[index++] = letterLog[0] + " " + letterLog[1];
        }
        return logs;
    }

    class LetterLogsComparator implements Comparator<String[]> {
        @Override
        public int compare(String[] o1, String[] o2) {
            if (!o1[1].equals(o2[1])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        }
    }

    private boolean isDigitLog(String[] split) {
        if (split[1].charAt(0) >= '0' && split[1].charAt(0) <= '9') {
            return true;
        }
        return false;
    }
}
