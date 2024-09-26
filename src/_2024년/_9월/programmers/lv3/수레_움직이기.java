package _2024년._9월.programmers.lv3;

import java.util.Arrays;

public class 수레_움직이기 {
    private int result = Integer.MAX_VALUE;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int n,m;

    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        int[] redStart = new int[2];
        int[] blueStart = new int[2];
        boolean[][][] visited = new boolean[n][m][2];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maze[i][j] == 1) {
                    redStart[0] = i;
                    redStart[1] = j;
                } else if(maze[i][j] == 2){
                    blueStart[0] = i;
                    blueStart[1] = j;
                }
            }
        }
        visited[redStart[0]][redStart[1]][0] = true;
        visited[blueStart[0]][blueStart[1]][1] = true;

        move(maze, redStart, blueStart, visited, false, false, 0);

        if(result == Integer.MAX_VALUE) {
            return 0;
        } else {
            return result;
        }
    }

    private void move(int[][] maze, int[] red, int[] blue, boolean[][][] visited, boolean redFlag, boolean blueFlag, int count) {
        if(redFlag && blueFlag) {
            result = Math.min(count, result);
            return;
        }

        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                int[] newRed = redFlag ? red : new int[]{red[0] + dx[i], red[1] + dy[i]};
                int[] newBlue = blueFlag ? blue : new int[]{blue[0] + dx[j], blue[1] + dy[j]};

                if(check(newRed, newBlue, red, blue, visited, maze, redFlag, blueFlag)) {
                    visited[newRed[0]][newRed[1]][0] = true;
                    visited[newBlue[0]][newBlue[1]][1] = true;

                    boolean newRedFlag = redFlag;
                    boolean newBlueFlag = blueFlag;
                    if(maze[newRed[0]][newRed[1]] == 3) {
                        newRedFlag = true;
                    }
                    if(maze[newBlue[0]][newBlue[1]] == 4) {
                        newBlueFlag = true;
                    }

                    move(maze, newRed, newBlue, visited, newRedFlag, newBlueFlag, count+1);

                    visited[newRed[0]][newRed[1]][0] = false;
                    visited[newBlue[0]][newBlue[1]][1] = false;
                }
            }
        }
    }

    private boolean check(int[] newRed, int[] newBlue, int[] red, int[] blue, boolean[][][] visited, int[][] maze, boolean redFlag, boolean blueFlag) {
        if(newRed[0] < 0 || newBlue[0] < 0 || newRed[0] >= n || newBlue[0] >= n || newRed[1] < 0 || newBlue[1] < 0
        || newRed[1] >= m || newBlue[1] >= m) {
            return false;
        }

        if(maze[newRed[0]][newRed[1]] == 5 || maze[newBlue[0]][newBlue[1]] == 5) {
            return false;
        }

        if((visited[newRed[0]][newRed[1]][0] && !redFlag) || (visited[newBlue[0]][newBlue[1]][1] && !blueFlag)) {
            return false;
        }

        if(Arrays.equals(newRed, newBlue)) {
            return false;
        }

        if(newRed[0] == blue[0] && newRed[1] == blue[1] && newBlue[0] == red[0] && newBlue[1] == red[1]) {
            return false;
        }

        return true;
    }
}
