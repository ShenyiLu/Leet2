package medium;

public class L1306JumpGame {
    private boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return recursive(arr, start);
    }

    private boolean recursive(int[] arr, int index) {
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }

        visited[index] = true;

        int left = index + arr[index];
        int right = index - arr[index];
        if (recursive(arr, left) || recursive(arr, right)) {
            return true;
        }
        return false;
    }
}
