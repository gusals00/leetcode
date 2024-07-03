package _2024년._7월.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];

            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node remove = pq.remove();

            for (Node node : graph.get(remove.index)) {
                if (dist[remove.index] + node.cost < dist[node.index]) {
                    dist[node.index] = dist[remove.index] + node.cost;
                    pq.add(node);
                }
            }
        }

        int result = 0;
        for (int distance : dist) {
            if(distance <= K) {
                result++;
            }
        }

        return result;
    }

    private static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
