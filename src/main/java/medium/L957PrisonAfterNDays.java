package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L957PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        // size 1 and 2 always empty
        if (cells.length < 3) {
            return new int[cells.length];
        }
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<List<Integer>> duplicate = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            List<Integer> nextList = toList(next);
            if (!duplicate.contains(nextList)) {
                duplicate.add(nextList);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if (hasCycle) {
            N %= cycle;
            for (int i = 0; i < N; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] nextDay = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            nextDay[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
        }
        return nextDay;
    }

    private List<Integer> toList(int[] cells) {
        List<Integer> result = new ArrayList<>();
        for (int i : cells) {
            result.add(i);
        }
        return result;
    }
}
