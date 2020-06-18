package easy;

import java.util.HashMap;
import java.util.List;

public class L219ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMap.containsKey(num)) {
                int j = hashMap.get(num);
                if (Math.abs(i - j) <= k) {
                    return true;
                }
            }
            hashMap.put(num, i);
        }
        return false;
    }
}
