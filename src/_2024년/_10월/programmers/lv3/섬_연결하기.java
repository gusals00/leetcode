package _2024년._10월.programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;

public class 섬_연결하기 {
    public int solution(int n, int[][] costs) {
        int result = 0;
        int[] parents = new int[n];
        for(int i=0; i<parents.length; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(cost -> cost[2]));

        for(int i=0; i<costs.length; i++) {
            if(find(parents, costs[i][0]) != find(parents, costs[i][1])) {
                union(parents, costs[i][0], costs[i][1]);
                result += costs[i][2];
            }
        }

        return result;
    }

    private void union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);

        if(a != b) {
            parents[b] = a;
        }
    }

    private int find(int[] parents, int a) {
        if(parents[a] != a) {
            return parents[a] = find(parents, parents[a]);
        }

        return parents[a];
    }
}
