package _2023년._10월.medium;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * matrix[0].length -1;

        while(start <= end) {
            int mid = (start+end) / 2;
            int value = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (value == target) {
                return true;
            } else if(value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
