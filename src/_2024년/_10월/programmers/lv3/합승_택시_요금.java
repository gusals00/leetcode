package _2024년._10월.programmers.lv3;

import java.util.*;

public class 합승_택시_요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[] distS = new int[n+1];
        int[] distA = new int[n+1];
        int[] distB = new int[n+1];
        Arrays.fill(distS, Integer.MAX_VALUE);
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
        distS[s] = 0;
        distA[a] = 0;
        distB[b] = 0;

        List<Node>[] list = new ArrayList[n+1];
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] fare : fares) {
            list[fare[0]].add(new Node(fare[1], fare[2]));
            list[fare[1]].add(new Node(fare[0], fare[2]));
        }

        dijkstra(distS, s, n, list);
        dijkstra(distA, a, n, list);
        dijkstra(distB, b, n, list);

        int result = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            result = Math.min(result, distS[i] + distA[i] + distB[i]);
        }

        return result;
    }

    private void dijkstra(int[] dist, int start, int n, List<Node>[] list) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        boolean[] visited = new boolean[n+1];
        queue.add(new Node(start, 0));

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
