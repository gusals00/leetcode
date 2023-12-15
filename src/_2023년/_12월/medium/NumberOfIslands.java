package _2023년._12월.medium;

public class NumberOfIslands {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, -0};

    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length
            && grid[nx][ny] == '1') {
                grid[nx][ny] = '0';
                dfs(grid, nx, ny);
            }
        }
    }
}
