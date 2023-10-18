package _2023년._10월.medium;

public class WordSearch {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(dfs(board, word, 1, i, j, visited)) return true;
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if(word.length() == index)
            return true;

        char nextChar = word.charAt(index);
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && 0 <= ny && nx < board.length && ny < board[0].length && !visited[nx][ny] && board[nx][ny] == nextChar) {
                visited[nx][ny] = true;
                if(dfs(board, word, index+1, nx, ny, visited)) return true;
                visited[nx][ny] = false;
            }
        }

        return false;
    }
}
