package _2024년._3월.medium;

import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);

        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int room) {
        visited[room] = true;

        for (int i : rooms.get(room)) {
            if(!visited[i]) {
                dfs(rooms, visited, i);
            }
        }
    }
}
