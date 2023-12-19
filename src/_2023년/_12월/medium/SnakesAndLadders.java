package _2023년._12월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int result = 0;
        int n = board.length * board.length;
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];

        boolean flag = true;
        int index = 1;
        for(int i=board.length-1; i>=0; i--) {
            if(flag) {
                for(int j=0; j<board.length; j++) {
                    arr[index++] = board[i][j];
                }
            } else {
                for(int j=board.length-1; j>=0; j--) {
                    arr[index++] = board[i][j];
                }
            }
            flag = !flag;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        if(arr[1] == -1) {
            queue.add(1);
        } else {
            queue.add(arr[1]);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int remove = queue.remove();
                if(remove == n) {
                    return result;
                }
                if(visited[remove]) {
                    continue;
                }

                visited[remove] = true;
                for(int j=remove+1; j<=Math.min(remove+6, n); j++) {
                    if(arr[j] == -1 && !visited[j]) {
                        queue.add(j);
                    } else if(arr[j] != -1 && !visited[arr[j]]) {
                        queue.add(arr[j]);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
