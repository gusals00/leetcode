package _2023년._8월.medium;

import java.util.Arrays;

public class NumberOfIslands {

    private boolean[][] visited;
    private int cnt = 0;
    private int[] dx = {0, 1, -1, 0};
    private int[] dy = {1, 0, 0, -1};

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<visited.length; i++) {
            Arrays.fill(visited[i], false);
        }

        for(int i=0; i<visited.length; i++) {
            for(int j=0; j<visited[i].length; j++) {
                if(!visited[i][j] && grid[i][j] =='1') {
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
            if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && !visited[nx][ny] && grid[nx][ny] == '1') {
                dfs(grid, nx, ny);
            }
        }
    }
}
