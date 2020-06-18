package easy;

import java.util.HashSet;

public class L217ContainsDuplicateI {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 0) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
}
