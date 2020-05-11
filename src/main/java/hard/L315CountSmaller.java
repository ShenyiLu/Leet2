package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L315CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> viewed = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        viewed.add(nums[nums.length - 1]);
        result.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int current = nums[i];
            result.add(insert(current, viewed));
        }
        Collections.reverse(result);
        return result;
    }

    private int insert(int current, List<Integer> viewed){
        for(int i = 0; i < viewed.size(); i++) {
            if(viewed.get(i) >= current){
                viewed.add(i, current);
                return i;
            }
        }
        viewed.add(current);
        return viewed.size() - 1;
    }
}
