package _2024년._3월.medium;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> conn = new ArrayList<>();
        for(int i=0; i<n; i++) {
            conn.add(new ArrayList<>());
        }
        
        for(int i=0; i<connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            conn.get(a).add(b);
            conn.get(b).add(-a);
        }

        boolean[] visited = new boolean[n];
        dfs(conn, 0, visited);

        return count;
    }

    private void dfs(List<List<Integer>> conn, int city, boolean[] visited) {
        visited[city] = true;

        for (int i : conn.get(city)) {
            if(!visited[Math.abs(i)]) {
                if(i >= 0) {
                    count++;
                }
                dfs(conn, Math.abs(i), visited);
            }
        }
    }
}
