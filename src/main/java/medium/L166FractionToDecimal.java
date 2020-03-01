package medium;

import java.util.HashMap;
import java.util.Map;

public class L166FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return Integer.MAX_VALUE + "";
        }
        StringBuilder builder = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            builder.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long ren = num / den;
        long rem = num % den;
        builder.append(ren);

        if (rem == 0) {
            return builder.toString();
        }
        builder.append(".");

        Map<Long, Integer> map = new HashMap<>();
        int beg = builder.length();
        while (rem > 0) {
            rem = rem * 10;
            ren = rem / den;
            if (map.containsKey(rem)) {
                String result = builder.toString();
                String part1 = result.substring(0, map.get(rem));
                String part2 = result.substring(map.get(rem));
                result = part1 + "(" + part2 + ")";
                return result;
            } else {
                builder.append(ren);
                map.put(rem, beg);
            }
            beg++;
            rem = rem % den;
        }
        return builder.toString();
    }
}
