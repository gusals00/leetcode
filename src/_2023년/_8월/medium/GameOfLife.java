package _2023년._8월.medium;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] tmp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int lives = getLives(board, i, j, m, n);
                if(board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    tmp[i][j] = 1;
                } else if(board[i][j] == 0 && lives == 3) {
                    tmp[i][j] = 1;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0 ;j<n; j++) {
                board[i][j] = tmp[i][j];
            }
        }
    }

    private int getLives(int[][] board, int i, int j, int m, int n) {
        int lives = 0;
        for(int x = Math.max(i-1,0); x <= Math.min(i+1, m-1); x++) {
            for(int y = Math.max(j-1,0); y <= Math.min(j+1, n-1); y++) {
                if(board[x][y]==1)
                    lives++;
            }
        }

        lives -= board[i][j];
        return lives;
    }
}
