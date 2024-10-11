package _2024년._10월.programmers.lv3;

import java.util.*;

public class 등산코스_정하기 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        List<Node>[] list = new ArrayList[n+1];
        Set<Integer> summit = new HashSet<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] path : paths) {
            list[path[0]].add(new Node(path[1], path[2]));
            list[path[1]].add(new Node(path[0], path[2]));
        }
        for(int i : gates) {
            queue.add(new Node(i, 0));
            dist[i] = 0;
        }
        for(int i : summits) {
            summit.add(i);
        }

        while(!queue.isEmpty()) {
            Node remove = queue.remove();
            int to = remove.to;
            if(remove.cost > dist[to]) {
                continue;
            }

            for(Node node : list[to]) {
                int distance = Math.max(dist[to], node.cost);
                if(dist[node.to] > distance) {
                    dist[node.to] = distance;
                    if(!summit.contains(node.to)) {
                        queue.add(new Node(node.to, distance));
                    }
                }
            }
        }

        int index = -1;
        int cost = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for(int i=0; i<summits.length; i++) {
            if(dist[summits[i]] < cost) {
                index = summits[i];
                cost = dist[summits[i]];
            }
        }

        return new int[]{index, cost};
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
