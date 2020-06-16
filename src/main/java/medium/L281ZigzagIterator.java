package medium;

import java.util.ArrayList;
import java.util.List;

public class L281ZigzagIterator {
    private List<Integer> zigzag;
    private int zigzagIndex;

    public L281ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        zigzag = new ArrayList<>();
        List<List<Integer>> v1v2 = new ArrayList<>();

        if (v1.size() > 0) {
            v1v2.add(v1);
        }
        if (v2.size() > 0) {
            v1v2.add(v2);
        }
        int maxSize = Math.max(v1.size(), v2.size());
        for (int i = 0; i < maxSize; i++) {
            for (List<Integer> list : v1v2) {
                if (list.size() > i) {
                    zigzag.add(list.get(i));
                }
            }
        }
        zigzagIndex = 0;
    }

    public int next() {
        int result = zigzag.get(zigzagIndex);
        zigzagIndex++;
        return result;
    }

    public boolean hasNext() {
        return zigzagIndex < zigzag.size();
    }
}
