package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L179LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> arrayList = new ArrayList<>();
        for (Integer i : nums) {
            arrayList.add("" + i);
        }
        Collections.sort(arrayList, new SortByName());
        StringBuilder builder = new StringBuilder();
        for (String i : arrayList) {
            builder.append(i);
        }

        while (builder.charAt(0) == '0' && builder.length() > 1) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    class SortByName implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return (str2 + str1).compareTo(str1 + str2);
        }
    }
}
