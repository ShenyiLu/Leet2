package medium;

import java.util.ArrayList;
import java.util.List;

public class L417PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int height = matrix.length;
        if (height == 0) {
            return result;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return result;
        }

        // special case
        if (height == 1 || width == 1) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
            return result;
        }

        boolean[][] matrixPacific = new boolean[height][width];
        boolean[][] matrixAtlantic = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            dfs(i, 0, matrixPacific, matrix);
            dfs(i, width - 1, matrixAtlantic, matrix);
        }
        for (int i = 0; i < width; i++) {
            dfs(0, i, matrixPacific, matrix);
            dfs(height - 1, i, matrixAtlantic, matrix);
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrixPacific[i][j] && matrixAtlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;

    }

    private void dfs(int height, int width, boolean[][] matrixOcean, int[][] matrix) {
        if (matrixOcean[height][width]) {
            return;
        }
        matrixOcean[height][width] = true;
        int localContinentHeight = matrix[height][width];

        int heightNext = height;
        int widthNext = width - 1;
        if (dfsCanReach(localContinentHeight, heightNext, widthNext, matrix)) {
            dfs(heightNext, widthNext, matrixOcean, matrix);
        }

        heightNext = height;
        widthNext = width + 1;
        if (dfsCanReach(localContinentHeight, heightNext, widthNext, matrix)) {
            dfs(heightNext, widthNext, matrixOcean, matrix);
        }

        heightNext = height - 1;
        widthNext = width;
        if (dfsCanReach(localContinentHeight, heightNext, widthNext, matrix)) {
            dfs(heightNext, widthNext, matrixOcean, matrix);
        }

        heightNext = height + 1;
        widthNext = width;
        if (dfsCanReach(localContinentHeight, heightNext, widthNext, matrix)) {
            dfs(heightNext, widthNext, matrixOcean, matrix);
        }
    }

    private boolean dfsCanReach(int localContinentHeight, int heightNext, int widthNext, int[][] matrix) {
        if (heightNext < 0 || heightNext >= matrix.length || widthNext < 0 || widthNext >= matrix[0].length) {
            return false;
        }

        int nextContinentHeight = matrix[heightNext][widthNext];
        return localContinentHeight <= nextContinentHeight;
    }
}
