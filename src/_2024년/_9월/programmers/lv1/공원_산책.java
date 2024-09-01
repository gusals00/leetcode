package _2024년._9월.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 공원_산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int x = park.length;
        int y = park[0].length();

        Map<String, Integer> map = new HashMap<>();
        map.put("N", 0);
        map.put("S", 1);
        map.put("W", 2);
        map.put("E", 3);

        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        for(int i=0; i<routes.length; i++) {
            String[] route = routes[i].split(" ");

            int index = map.get(route[0]);
            int value = Integer.parseInt(route[1]);
            boolean check = true;

            int nx = start[0];
            int ny = start[1];
            for(int j=0; j<value; j++) {
                nx += dx[index];
                ny += dy[index];

                if(0 > nx || nx >= x || 0 > ny || ny >= y || park[nx].charAt(ny) == 'X') {
                    check = false;
                    break;
                }
            }

            if(check) {
                start[0] = nx;
                start[1] = ny;
            }
        }

        return start;
    }
}
