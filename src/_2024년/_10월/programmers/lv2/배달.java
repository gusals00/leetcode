package _2024년._10월.programmers.lv2;

import java.util.*;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        List<Node>[] list = new ArrayList[N+1];
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            list[r[0]].add(new Node(r[1], r[2]));
            list[r[1]].add(new Node(r[0], r[2]));
        }

        dist[1] = 0;
        queue.add(new Node(1, 0));
        while(!queue.isEmpty()) {
            Node remove = queue.remove();
            int to = remove.to;

            if(visited[to]) {
                continue;
            } else {
                visited[to] = true;
            }

            for(Node node : list[to]) {
                if(dist[node.to] > dist[to] + node.cost) {
                    dist[node.to] = dist[to] + node.cost;
                    queue.add(new Node(node.to, dist[node.to]));
                }
            }
        }

        int result = 0;
        for(int i=1; i<dist.length; i++) {
            if(dist[i] <= K) {
                result++;
            }
        }

        return result;
    }

    private static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
