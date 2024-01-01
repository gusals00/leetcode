package _2024년._1월.medium;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int row = matrix[0].length;
        int end = matrix.length * row - 1;

        while(start <= end) {
            int midIndex = (start + end) / 2;
            int midValue = matrix[midIndex / row][midIndex % row];
            if(midValue == target) {
                return true;
            } else if(midValue < target) {
                start = midIndex + 1;
            } else {
                end = midIndex - 1;
            }
        }

        return false;
    }
}
