package _2024년._4월.medium;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;
        int row = matrix.length-1;

        while(0 <= row && col < matrix[0].length) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }

        return false;
    }
}
