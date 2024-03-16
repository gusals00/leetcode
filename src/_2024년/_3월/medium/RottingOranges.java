package _2024년._3월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int minute = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) {
            return minute;
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] remove = queue.remove();

                for(int j=0; j<4; j++) {
                    int x = remove[0] + dx[j];
                    int y = remove[1] + dy[j];
                    if(0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1) {
                        queue.add(new int[]{x,y});
                        fresh--;
                        grid[x][y] = 2;
                    }
                }
            }
            minute++;
        }

        if(fresh == 0) {
            return minute-1;
        } else {
            return -1;
        }
    }
}
