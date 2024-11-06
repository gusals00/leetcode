package _2024년._11월.programmers.lv3;

import java.util.*;

public class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, 1_000_000_000);
        dist[destination] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(destination);
        boolean[] visited = new boolean[n+1];

        while(!queue.isEmpty()) {
            int remove = queue.remove();

            if(visited[remove]) {
                continue;
            } else {
                visited[remove] = true;
            }

            for (int i : list[remove]) {
                if(dist[i] > dist[remove] + 1) {
                    dist[i] = dist[remove] + 1;
                    queue.add(i);
                }
            }
        }

        int[] result = new int[sources.length];
        for(int i=0; i<sources.length; i++) {
            if(dist[sources[i]] == 1_000_000_000) {
                result[i] = -1;
            } else {
                result[i] = dist[sources[i]];
            }
        }

        return result;
    }
}
