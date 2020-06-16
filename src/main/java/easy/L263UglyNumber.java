package easy;

import java.util.ArrayList;
import java.util.List;

public class L263UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        List<Integer> factors = new ArrayList<>();
        factors.add(2);
        factors.add(3);
        factors.add(5);

        for (int factor : factors) {
            num = divide(num, factor);
        }

        if (factors.contains(num)) {
            return true;
        }
        return false;
    }

    private int divide(int num, int factor) {
        while (num > factor && num % factor == 0) {
            num /= factor;
        }
        return num;
    }
}
