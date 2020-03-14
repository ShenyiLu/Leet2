package medium;

import java.util.ArrayList;
import java.util.List;

public class L254GetFactors {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, 2);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int n, int start) {
        if (n <= 1) {
            if (current.size() > 1) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                current.add(i);
                dfs(result, current, n / i, i);
                current.remove(current.size() - 1);
            }
        }
    }
}
