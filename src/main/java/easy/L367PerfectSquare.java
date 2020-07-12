package easy;

public class L367PerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 4) {
            return false;
        }
        return find(2, num / 2 + num % 2, num);
    }

    private boolean find(int head, int tail, int num) {
        if ((double)head * head == num || (double)tail * tail == num) {
            return true;
        }
        double pivot = ((double)head + tail) / 2;
        double pivotSquare = pivot * pivot;
        if (pivotSquare == num) {
            return true;
        } else if (pivotSquare < num) {
            if (pivot >= tail - 1) {
                return false;
            }
            return find((int)pivot, tail - 1, num);
        } else {
            if (head + 1 >= pivot) {
                return false;
            }
            return find(head + 1, (int)pivot, num);
        }
    }
}
