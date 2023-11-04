package _2023년._11월.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-i-1][j];
                matrix[length-i-1][j] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
