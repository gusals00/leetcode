package _2023년._11월.medium;

public class WordSearch {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(board, i, j, 1, word, visited)) return true;
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int index, String word, boolean[][] visited) {
        if(word.length() == index)
            return true;

        char nextChar = word.charAt(index);
        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(0 <= nx && 0 <= ny && nx < board.length && ny < board[0].length && !visited[nx][ny] && board[nx][ny] == nextChar) {
                visited[nx][ny] = true;
                if(dfs(board, nx, ny, index+1, word, visited)) {
                    return true;
                }
                visited[nx][ny] = false;
            }
        }

        return false;
    }
}
