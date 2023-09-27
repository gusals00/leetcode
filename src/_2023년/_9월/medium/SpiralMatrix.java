package _2023년._9월.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = 0;
        int rowEnd = m-1;
        int colEnd = n-1;

        while(row <= rowEnd && col <= colEnd) {
            for(int i=row; i<=rowEnd; i++)
                result.add(matrix[col][i]);

            col++;

            for(int i=col; i<=colEnd; i++)
                result.add(matrix[i][rowEnd]);

            rowEnd--;

            if(row > rowEnd || col > colEnd) break;

            for(int i=rowEnd; i>=row; i--)
                result.add(matrix[colEnd][i]);

            colEnd--;

            for(int i=colEnd; i>=col; i--)
                result.add(matrix[i][row]);

            row++;
        }

        return result;
    }
}
