package _2023년._10월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int result = 0;
        int length = board.length;
        int[] arr = new int[length * length + 1];
        boolean[] visited = new boolean[length * length + 1];

        int index = 1;
        boolean flag = true;
        for(int i=length-1; i>=0; i--) {
            if(flag) {
                for(int j=0; j<length; j++) {
                    arr[index++] = board[i][j];
                }
            } else {
                for(int j=length-1; j>=0; j--) {
                    arr[index++] = board[i][j];
                }
            }

            flag = !flag;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        if(arr[1] == -1)
            deque.add(1);
        else
            deque.add(arr[1]);

        while(!deque.isEmpty()) {
            int size = deque.size();

            for(int i=0; i<size; i++) {
                int remove = deque.remove();
                if(length * length == remove)
                    return result;

                if(visited[remove]) {
                    continue;
                }
                visited[remove] = true;

                for(int j=remove+1; j<=Math.min(remove+6, length*length); j++) {
                    if (arr[j] == -1 && !visited[j])
                        deque.add(j);
                    else if(arr[j] != -1 && !visited[arr[j]])
                        deque.add(arr[j]);
                }
            }
            result++;
        }

        return -1;
    }
}
