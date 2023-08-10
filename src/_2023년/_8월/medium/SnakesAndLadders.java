package _2023년._8월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1];
        boolean[] visited = new boolean[n * n + 1];

        int index = 1;
        boolean flag = true;
        for(int i = n -1; i>=0; i--) {
            if(flag) {
                for (int j = 0; j < n; j++)
                    arr[index++] = board[i][j];
            } else {
                for (int j = n - 1; j >= 0; j--)
                    arr[index++] = board[i][j];
            }
            flag=!flag;
        }

        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        if(arr[1] == -1)
            queue.add(1);
        else
            queue.add(arr[1]);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int poll = queue.poll();
                if(visited[poll]) continue;
                visited[poll] = true;

                if(poll == n * n)
                    return cnt;

                for(int j=poll+1; j<=Math.min(poll+6, n*n); j++) {
                    if(arr[j] == -1)
                        queue.add(j);
                    else
                        queue.add(arr[j]);
                }
            }
            cnt++;
        }
        return -1;
    }
}
