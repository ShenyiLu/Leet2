package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L170TwoSum {
    List<Integer> arrayList;
    boolean isSorted;

    /** Initialize your data structure here. */
    public L170TwoSum() {
         arrayList = new ArrayList<>();
         isSorted = false;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        arrayList.add(number);
        isSorted = false;
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (!isSorted) {
            Collections.sort(arrayList);
        }
        int tail = 0;
        int head = arrayList.size() - 1;
        while (tail < head) {
            if (arrayList.get(tail) + arrayList.get(head) == value) {
                return true;
            }
            if (arrayList.get(tail) + arrayList.get(head) < value) {
                tail++;
            } else {
                head--;
            }
        }
        return false;
    }
}
