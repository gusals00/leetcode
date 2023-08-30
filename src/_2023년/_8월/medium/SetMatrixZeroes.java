package _2023년._8월.medium;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    cols.add(j);
                    rows.add(i);
                }
            }
        }

        for(int r : rows) {
            for(int i=0; i<matrix[0].length; i++) {
                matrix[r][i] = 0;
            }
        }

        for(int c : cols) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
