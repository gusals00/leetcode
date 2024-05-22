package _2024년._5월.programmers.lv2;


import java.util.ArrayDeque;
import java.util.Queue;

public class 전력망을_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        int result = Integer.MAX_VALUE;
        boolean[][] arr = new boolean[n+1][n+1];

        for(int i=0; i<wires.length; i++) {
            int first = wires[i][0];
            int second = wires[i][1];

            arr[first][second] = true;
            arr[second][first] = true;
        }
        
        for(int i=0; i<wires.length; i++) {
            int first = wires[i][0];
            int second = wires[i][1];
            
            arr[first][second] = false;
            arr[second][first] = false;

            int left = bfs(n, arr, first);
            int right = bfs(n, arr, second);
            result = Math.min(result, Math.abs(left-right));

            arr[first][second] = true;
            arr[second][first] = true;
        }

        return result;
    }
    
    private int bfs(int n, boolean[][] arr, int start) {
        int count = 1;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int remove = queue.remove();
            visited[remove] = true;

            for(int i=1; i<=n; i++) {
                if(arr[remove][i] && !visited[i]) {
                    queue.add(i);
                }
            }
            count++;
        }

        return count;
    }
}
