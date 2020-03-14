package easy;

public class L256PaintHouse {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        int min = costs[costs.length - 1][0];
        for (int i = 1; i < costs[0].length; i++) {
            min = Math.min(min, costs[costs.length - 1][i]);
        }
        return min;
    }
}
