package _2024년._5월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 미로_탈출 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];

        for(int i=0; i<maps.length; i++) {
            char[] chars = maps[i].toCharArray();
            map[i] = chars;

            for(int j=0; j<chars.length; j++) {
                if(map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if(map[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        int leverCount = bfs(map, start[0], start[1], 'L');
        int exitCount = bfs(map, lever[0], lever[1], 'E');

        if(leverCount == -1 || exitCount == -1) {
            return -1;
        } else {
            return leverCount + exitCount;
        }
    }

    private int bfs(char[][] map, int x, int y, char target) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] remove = queue.remove();
                if(map[remove[0]][remove[1]] == target) {
                    return count;
                }

                for(int j=0; j<4; j++) {
                    int nx = remove[0] + dx[j];
                    int ny = remove[1] + dy[j];

                    if(0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length && !visited[nx][ny] && map[nx][ny] != 'X') {
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
