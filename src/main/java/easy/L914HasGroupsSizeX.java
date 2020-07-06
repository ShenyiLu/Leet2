package easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L914HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int val : deck) {
            hashMap.put(val, 1 + hashMap.getOrDefault(val, 0));
        }

        List<BigInteger> values = new ArrayList<>();
        for (int i : hashMap.values()) {
            values.add(BigInteger.valueOf(i));
        }
        BigInteger denom = BigInteger.valueOf(0);
        for (BigInteger bi : values) {
            if (denom.intValue() == 0) {
                denom = bi;
            } else {
                denom = bi.gcd(denom);
            }
            if (denom.intValue() == 1) {
                return false;
            }
        }

        return true;
    }
}
