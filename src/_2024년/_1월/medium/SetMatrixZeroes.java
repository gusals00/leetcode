package _2024년._1월.medium;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows) {
            for(int i=0; i<matrix[row].length; i++) {
                matrix[row][i] = 0;
            }
        }
        for(int col : cols) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
