package medium;

public class L201BitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int range = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            range++;
        }
        return m <<= range;
    }
}
