package easy;

import java.util.HashSet;

public class L202HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> exist = new HashSet<>();
        while (!exist.contains(process(n))) {
            int temp = process(n);
            if (temp == 1) {
                return true;
            }
            exist.add(temp);
            n = temp;
        }
        return false;
    }

    private int process(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}


