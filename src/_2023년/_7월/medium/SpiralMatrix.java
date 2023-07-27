package _2023년._7월.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = 0;
        int rowEnd = m-1;
        int colEnd = n-1;

        List<Integer> list = new ArrayList<>();

        while(list.size() < n * m) {
            for(int i=row; i<=rowEnd && list.size() < n * m; i++)
                list.add(matrix[col][i]);

            for(int i=col+1; i<=colEnd-1 && list.size() < n * m; i++)
                list.add(matrix[i][rowEnd]);

            for(int i=rowEnd; i>=row && list.size() < n * m; i--)
                list.add(matrix[colEnd][i]);

            for(int i=colEnd-1; i>=col+1 && list.size() < n * m; i--)
                list.add(matrix[i][row]);

            row++;
            rowEnd--;
            col++;
            colEnd--;
        }

        return list;
    }
}
