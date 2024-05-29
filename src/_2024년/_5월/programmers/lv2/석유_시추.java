package _2024년._5월.programmers.lv2;

import java.util.*;

public class 석유_시추 {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public int solution(int[][] land) {
        Set<Integer> pipe = new HashSet<>();
        int[] oil = new int[land[0].length];

        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[i].length; j++) {
                if(land[i][j] == 1) {
                    pipe.clear();
                    bfs(land, pipe, oil, i, j);
                }
            }
        }

        return Arrays.stream(oil).max().getAsInt();
    }

    private void bfs(int[][] land, Set<Integer> pipe, int[] oil, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        land[x][y] = 0;
        pipe.add(y);
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] remove = queue.remove();
            count++;

            for(int i=0; i<4; i++) {
                int nx = remove[0] + dx[i];
                int ny = remove[1] + dy[i];

                if(0 <= nx && nx < land.length && 0 <= ny && ny < land[0].length
                        && land[nx][ny] != 0) {
                    land[nx][ny] = 0;
                    pipe.add(ny);
                    queue.add(new int[]{nx,ny});
                }
            }
        }

        for (int index : pipe) {
            oil[index] += count;
        }
    }
}
