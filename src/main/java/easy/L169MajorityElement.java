package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L169MajorityElement {
    public int majorityElement(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i : nums) {
            numList.add(i);
        }
        Collections.sort(numList);
        return numList.get(numList.size() / 2);
    }
}
