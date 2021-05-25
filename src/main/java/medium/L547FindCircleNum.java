package medium;

public class L547FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count += 1;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int cityIndex) {
        visited[cityIndex] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[cityIndex][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
