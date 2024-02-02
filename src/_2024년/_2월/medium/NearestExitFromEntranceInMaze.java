package _2024년._2월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int step = 0;
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] remove = queue.remove();

                for(int j=0; j<4; j++) {
                    int x = remove[0] + dx[j];
                    int y = remove[1] + dy[j];

                    if(0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == '.') {
                        if(x == 0 || y == 0 || x == maze.length-1 || y == maze[0].length-1) {
                            return step;
                        }
                        queue.add(new int[]{x,y});
                        maze[x][y] = '+';
                    }
                }
            }
        }

        return -1;
    }
}
