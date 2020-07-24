package easy;

import java.util.ArrayList;
import java.util.List;

public class L448DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] result = new boolean[nums.length];
        for (int i : nums) {
            result[i] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (!result[i]) {
                list.add(i);
            }

        }
        return list;
    }
}
