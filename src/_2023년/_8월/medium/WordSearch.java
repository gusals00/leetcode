package _2023년._8월.medium;

public class WordSearch {

    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        char start = word.charAt(0);
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == start) {
                    visited[i][j] = true;
                    if(recur(board, word, 1, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean recur(char[][] board, String word, int index, int x, int y) {
        if(index == word.length()) {
            return true;
        }

        boolean result = false;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && !visited[nx][ny]) {
                if(board[nx][ny] == word.charAt(index)) {
                    visited[nx][ny] = true;
                    result = recur(board, word, index + 1, nx, ny);
                    if(result) break;
                    visited[nx][ny] = false;
                }
            }
        }

        return result;
    }
}
