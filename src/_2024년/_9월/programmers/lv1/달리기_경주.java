package _2024년._9월.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int rank = map.get(calling);
            String player = players[rank - 1];

            players[rank-1] = calling;
            players[rank] = player;

            map.put(calling, rank-1);
            map.put(player, rank);
        }

        return players;
    }
}
