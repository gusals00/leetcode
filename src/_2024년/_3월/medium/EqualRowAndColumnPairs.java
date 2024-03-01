package _2024년._3월.medium;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap<>();
        Map<String, Integer> cols = new HashMap<>();
        int result = 0;

        for(int i=0; i<grid.length; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();

            for(int j=0; j<grid[i].length; j++) {
                row.append(grid[i][j]).append('.');
                col.append(grid[j][i]).append('.');
            }
            rows.put(row.toString(), rows.getOrDefault(row.toString(),0) + 1);
            cols.put(col.toString(), cols.getOrDefault(col.toString(),0) + 1);
        }

        for (String s : rows.keySet()) {
            if(cols.containsKey(s)) {
                result += rows.get(s) * cols.get(s);
            }
        }

        return result;
    }
}
