package _2024년._11월.programmers.lv3;

public class _2차원_동전_뒤집기 {
    private int result = Integer.MAX_VALUE;

    public int solution(int[][] beginning, int[][] target) {
        dfs(beginning, target, 0, 0, beginning.length);

        if(result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    private void dfs(int[][] begin, int[][] target, int row, int flipCount, int rows) {
        if(rows == row) {
            int count = 0;

            for(int i=0; i<target[0].length; i++) {
                int check = checkCols(begin, target, i);
                if(check == -1) {
                    return;
                }

                count += check;
            }

            result = Math.min(result, count+flipCount);
            return;
        }

        flipRow(begin, row);
        dfs(begin, target, row+1, flipCount+1, rows);
        flipRow(begin, row);

        dfs(begin, target, row+1, flipCount, rows);
    }

    private int checkCols(int[][] begin, int[][] target, int col) {
        int match = 0;
        for(int i = 0; i < target.length; i++) {
            if(begin[i][col] == target[i][col]) {
                match++;
            }
        }

        if(match == target.length) {
            return 0;
        } else if(match == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    private void flipRow(int[][] begin, int row) {
        for(int i=0; i<begin[0].length; i++) {
            begin[row][i] = (begin[row][i]+1)%2;
        }
    }
}
