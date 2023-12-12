package _2023년._12월.medium;

public class SurroundedRegions {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O' && !visited[0][i]) {
                dfs(board, visited, 0, i);
            }
            if(board[n -1][i] == 'O' && !visited[n -1][i]) {
                dfs(board, visited, n -1, i);
            }
        }
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, visited, i, 0);
            }
            if(board[i][n-1] == 'O' && !visited[i][n-1]) {
                dfs(board, visited, i, m -1);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length
            && !visited[nx][ny] && board[nx][ny] == 'O') {
                dfs(board, visited, nx, ny);
            }
        }
    }
}
