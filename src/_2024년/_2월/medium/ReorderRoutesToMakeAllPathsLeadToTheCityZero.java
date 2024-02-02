package _2024년._2월.medium;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    private int count = 0;

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> connection = new ArrayList<>();
        for(int i=0; i<n; i++) {
            connection.add(new ArrayList<>());
        }
        for (int[] ints : connections) {
            connection.get(ints[0]).add(ints[1]);
            connection.get(ints[1]).add(-ints[0]);
        }

        dfs(0, connection, new boolean[n]);
        return count;
    }

    private void dfs(int n, List<List<Integer>> connection, boolean[] visited) {
        visited[n] = true;
        for (int i : connection.get(n)) {
            if(!visited[Math.abs(i)]) {
                if(i >= 0) {
                    count++;
                }
                dfs(Math.abs(i), connection, visited);
            }
        }
    }
}
