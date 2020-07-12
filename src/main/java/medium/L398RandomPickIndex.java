package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L398RandomPickIndex {
    HashMap<Integer, List<Integer>> indexMap;

    public L398RandomPickIndex(int[] nums) {
        indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            indexMap.putIfAbsent(num, new ArrayList<>());
            indexMap.get(num).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = indexMap.get(target);
        if (list.size() == 1) {
            return list.get(0);
        }

        int random;
        do {
            random = (int) (Math.random() * list.size());
        } while (random >= list.size());

        return list.get(random);
    }
}
