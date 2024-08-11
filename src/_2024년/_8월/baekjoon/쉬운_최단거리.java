package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운_최단거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] start = new int[2];
        int[][] arr = new int[n][m];
        init(br, n, m, start, arr);

        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        bfs(n, m, start, arr, distance, visited);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    sb.append("-1 ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int n, int m, int[] start, int[][] arr, int[][] distance, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        arr[start[0]][start[1]] = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int dist = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i< size; i++) {
                int[] remove = queue.remove();
                distance[remove[0]][remove[1]] = dist;

                for(int j=0; j<4; j++) {
                    int nx = remove[0] + dx[j];
                    int ny = remove[1] + dy[j];

                    if(0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && arr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }

            dist++;
        }
    }

    private static void init(BufferedReader br, int n, int m, int[] start, int[][] arr) throws IOException {
        StringTokenizer st;
        for(int i = 0; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;

                if(value == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
    }
}
