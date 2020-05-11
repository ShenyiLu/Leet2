package medium;

import java.util.ArrayList;
import java.util.List;

public class L417PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int height = matrix.length;
        if(height == 0) {
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

        // TODO
        return result;

    }
}
