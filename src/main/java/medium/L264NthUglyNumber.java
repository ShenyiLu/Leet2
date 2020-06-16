package medium;

public class L264NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] uglys = new int[n];

        uglys[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            uglys[i] = min;
            if (factor2 == min) {
                index2++;
                factor2 = 2 * uglys[index2];
            }
            if (factor3 == min) {
                index3++;
                factor3 = 3 * uglys[index3];
            }
            if (factor5 == min) {
                index5++;
                factor5 = 5 * uglys[index5];
            }
        }
        return uglys[n - 1];

    }
}
