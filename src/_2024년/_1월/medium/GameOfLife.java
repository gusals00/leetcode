package _2024년._1월.medium;

public class GameOfLife {
    int[] dx = {-1, 0, 1, 1, -1, -1, 0, 1};
    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                int lives = 0;
                for(int k=0; k<8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length
                    && (board[nx][ny] == 1 || board[nx][ny] == 2)) {
                        lives++;
                    }
                }
                if(board[i][j] == 0 && lives == 3) {
                    board[i][j] = 3;
                } else if(board[i][j] == 1 && (lives < 2 || lives > 3)) {
                    board[i][j] = 2;
                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] %= 2;
                }
            }
        }
    }
}
