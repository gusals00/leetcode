package _2024년._5월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 리코쳇_로봇 {
    public int solution(String[] board) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;

        int[] start = new int[2];
        int[] goal = new int[2];
        boolean[][] visited = new boolean[board.length][board[0].length()];

        for(int i=0; i<board.length; i++) {
            char[] chars = board[i].toCharArray();
            for(int j=0; j<chars.length; j++) {
                if(chars[j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                if(chars[j] == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] remove = queue.remove();

                if(Arrays.equals(remove, goal)) {
                    return count;
                }

                for(int j=0; j<4; j++) {
                    int nx = remove[0] + dx[j];
                    int ny = remove[1] + dy[j];

                    while(0 <= nx && nx < board.length && 0 <= ny && ny <board[0].length()
                    && board[nx].charAt(ny) != 'D') {
                        nx += dx[j];
                        ny += dy[j];
                    }

                    nx -= dx[j];
                    ny -= dy[j];
                    if(!visited[nx][ny]) {
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
