package _2023년._10월.medium;

public class SurroundedRegions {
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    private boolean[][] visited;

    public void solve(char[][] board) {
        visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board[0].length; i++) {
            if(board[0][i] == 'O' && !visited[0][i])
                dfs(board, 0, i);
            if(board[board.length-1][i] == 'O' && !visited[board.length-1][i])
                dfs(board, board.length-1, i);
        }

        for(int i=0; i<board.length; i++) {
            if(board[i][0] == 'O' && !visited[i][0])
                dfs(board, i, 0);
            if(board[i][board[0].length-1] == 'O' && !visited[i][board[0].length-1])
                dfs(board, i, board[0].length-1);
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
    private void dfs(char[][] board, int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && 0 <= ny && nx < board.length && ny < board[0].length && !visited[nx][ny] && board[nx][ny] == 'O')
                dfs(board,nx,ny);
        }
    }
}
