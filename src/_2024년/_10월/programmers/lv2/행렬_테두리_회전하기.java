package _2024년._10월.programmers.lv2;

public class 행렬_테두리_회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] result = new int[queries.length];
        int[][] arr = new int[rows+1][columns+1];
        int num = 1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                arr[i][j] = num++;
            }
        }

        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            int min = Integer.MAX_VALUE;
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            int temp = arr[x1][y1];
            min = Math.min(temp, min);
            for (int i = x1; i < x2; i++) {
                arr[i][y1] = arr[i + 1][y1];
                min = Math.min(arr[i][y1], min);
            }

            for (int i = y1; i < y2; i++) {
                arr[x2][i] = arr[x2][i + 1];
                min = Math.min(arr[x2][i], min);
            }

            for (int i = x2; i > x1; i--) {
                arr[i][y2] = arr[i - 1][y2];
                min = Math.min(arr[i][y2], min);
            }

            for(int i = y2; i > y1+1; i--) {
                arr[x1][i] = arr[x1][i-1];
                min = Math.min(arr[x1][i], min);
            }

            arr[x1][y1+1] = temp;

            result[j] = min;
        }

        return result;
    }
}
