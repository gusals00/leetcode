package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과_사다리_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[101];
        int result = 0;

        for(int i=0; i<n+m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        visited[1] = true;
        queue.add(1);
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int remove = queue.remove();
                if(remove == 100) {
                    System.out.println(result);
                    return;
                }

                for(int j=remove; j<=remove+6 && j<=100; j++) {
                    if(visited[j]) continue;

                    if(arr[j] == 0) {
                        queue.add(j);
                    } else {
                        queue.add(arr[j]);
                    }
                    visited[j] = true;
                }
            }

            result++;
        }

        System.out.println(result);
    }
}
