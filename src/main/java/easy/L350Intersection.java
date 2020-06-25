package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L350Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || Math.min(nums1.length, nums2.length) <= 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> hashMap1 = initMap(nums1);
        HashMap<Integer, Integer> hashMap2 = initMap(nums2);
        List<Integer> result;
        if (hashMap1.keySet().size() < hashMap2.keySet().size()) {
            result = getResult(hashMap1, hashMap2);
        } else {
            result = getResult(hashMap2, hashMap1);
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

    private HashMap<Integer, Integer> initMap(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 0);
            }
            hashMap.replace(num, 1 + hashMap.get(num));
        }
        return hashMap;
    }

    private List<Integer> getResult(HashMap<Integer, Integer> hashMap1, HashMap<Integer, Integer> hashMap2) {
        List<Integer> result = new ArrayList<>();
        for (int num : hashMap1.keySet()) {
            int size = Math.min(hashMap1.get(num), hashMap2.getOrDefault(num, 0));
            for (int i = 0; i < size; i++) {
                result.add(num);
            }
        }
        return result;
    }
}
