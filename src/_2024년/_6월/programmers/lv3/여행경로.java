package _2024년._6월.programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 여행경로 {
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        List<String> routes = new ArrayList<>();

        dfs(tickets, "ICN", "ICN", 0, visited, routes);
        Collections.sort(routes);

        return routes.get(0).split(" ");
    }

    private void dfs(String[][] tickets, String route, String start, int count, boolean[] visited, List<String> routes) {
        if(count == tickets.length) {
            routes.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, route + " " + tickets[i][1], tickets[i][1], count+1, visited, routes);
                visited[i] = false;
            }
        }
    }
}
