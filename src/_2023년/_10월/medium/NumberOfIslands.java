package _2023년._10월.medium;

public class NumberOfIslands {
    private int[] dx = {1, 0, -1 ,0};
    private int[] dy = {0, -1, 0, 1};
    private boolean[][] visited;
    private int cnt = 0;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && 0 <= ny && nx < grid.length && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == '1') {
                dfs(grid, nx, ny);
            }
        }
    }
}
