package easy;

import java.util.HashMap;
import java.util.HashSet;

public class L532DiffPairs {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        if (k < 0) {
            return 0;
        }
        if (k == 0) {
            HashSet<Integer> duplicate = new HashSet<>();
            for (int num : nums) {
                if (hashSet.contains(num)) {
                    duplicate.add(num);
                } else {
                    hashSet.add(num);
                }
            }
            return duplicate.size();
        }

        for (int num : nums) {
            hashSet.add(num);
        }
        int count = 0;
        for (int num : hashSet) {
            // one-direction
            if (hashSet.contains(num + k)) {
                count++;
            }
        }
        return count;
    }
}
