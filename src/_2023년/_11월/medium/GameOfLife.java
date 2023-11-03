package _2023년._11월.medium;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[] dx = {-1, 1, 1, 0, 0, -1, 1, -1};
        int[] dy = {-1, 0, 1, -1, 1, 0, -1, 1};

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lives = 0;
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(0 <= nx && 0 <= ny && nx < n && ny < m && (board[nx][ny] == 1 || board[nx][ny] == 2))
                        lives++;
                }
                if(board[i][j] == 0 && lives == 3)
                    board[i][j] = 3;
                else if(board[i][j] == 1 && (lives < 2 || lives > 3))
                    board[i][j] = 2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 3 || board[i][j] == 2) {
                    board[i][j] %= 2;
                }
            }
        }
    }
}
