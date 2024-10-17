package _2024년._10월.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 빛의_경로_사이클 {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        List<Integer> result = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length();
        boolean[][][] visited = new boolean[n][m][4];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<4; k++) {
                    if(!visited[i][j][k]) {
                        int cycleLength = getCycleLength(grid, i, j, visited, k);
                        result.add(cycleLength);
                    }
                }
            }
        }

        return result.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int getCycleLength(String[] grid, int x, int y, boolean[][][] visited, int direction) {
        int count = 0;

        while(!visited[x][y][direction]) {
            visited[x][y][direction] = true;

            if(grid[x].charAt(y) == 'L') {
                direction = (direction+1) % 4;
            }
            if(grid[x].charAt(y) == 'R') {
                direction = (direction+3) % 4;
            }

            x = (x + dx[direction] + grid.length) % grid.length;
            y = (y + dy[direction] + grid[0].length()) % grid[0].length();

            count++;
        }

        return count;
    }
}
