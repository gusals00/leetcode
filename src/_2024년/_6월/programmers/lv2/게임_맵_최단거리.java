package _2024년._6월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임_맵_최단거리 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[0][0] = 1;
        queue.add(new int[]{0,0});
        int[] dx = {0, 0 -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] remove = queue.remove();
                if(remove[0] == n-1 && remove[1] == m-1) {
                    return visited[remove[0]][remove[1]];
                }

                for(int j=0; j<4; j++) {
                    int nx = remove[0] + dx[j];
                    int ny = remove[1] + dy[j];

                    if(0 <= nx && nx < n && 0 <= ny && ny < m
                    && maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[remove[0]][remove[1]] + 1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

        return -1;
    }
}
