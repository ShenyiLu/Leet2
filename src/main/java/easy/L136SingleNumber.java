package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L136SingleNumber {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        Collections.sort(list);
        System.out.println(list);
        int head = 0;
        int tail = 1;
        while (head < list.size()) {
            if (tail >= list.size()) {
                return head;
            }
            if (head == 0) {
                System.out.println(list.get(head));
                System.out.println(list.get(tail));
                System.out.println(list.get(head) == list.get(tail));
                System.out.println("wtf");
            }

            if (list.get(head) - list.get(tail) != 0) {
                return list.get(tail) - list.get(tail + 1) == 0 ? list.get(head) : list.get(tail);
            }
            head+=2;
            tail+=2;
        }
        return 0;
    }
}
