package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L349Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || Math.min(nums1.length, nums2.length) <= 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        if (result.size() == 0) {
            return new int[0];
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;

    }
}
