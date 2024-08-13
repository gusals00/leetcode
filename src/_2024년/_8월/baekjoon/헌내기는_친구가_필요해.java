package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는_친구가_필요해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] start = new int[2];
        for(int i=0; i<n; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                arr[i][j] = chars[j];
                if(arr[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while(!queue.isEmpty()) {
            int[] remove = queue.remove();
            for(int i=0; i<4; i++) {
                int nx = remove[0] + dx[i];
                int ny = remove[1] + dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && arr[nx][ny] != 'X') {
                    if(arr[nx][ny] == 'P') {
                        result++;
                    }

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }

        if(result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }
}
