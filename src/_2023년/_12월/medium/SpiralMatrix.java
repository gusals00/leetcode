package _2023년._12월.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = 0;
        int colEnd = m-1;
        int rowEnd = n-1;

        while(col <= colEnd && row <= rowEnd) {
            for(int i=col; i<=colEnd; i++)
                result.add(matrix[row][i]);
            row++;

            for(int i=row; i<=rowEnd; i++)
                result.add(matrix[i][colEnd]);
            colEnd--;

            if(col > colEnd || row > rowEnd)
                break;

            for(int i=colEnd; i>=col; i--)
                result.add(matrix[rowEnd][i]);
            rowEnd--;

            for(int i=rowEnd; i>=row; i--)
                result.add(matrix[i][col]);
            col++;
        }

        return result;
    }
}
