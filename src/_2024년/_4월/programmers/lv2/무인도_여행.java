package _2024년._4월.programmers.lv2;

import java.util.LinkedList;
import java.util.List;

public class 무인도_여행 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int count = 0;

    public int[] solution(String[] maps) {
        char[][] charMaps = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
            String map = maps[i];
            for(int j=0; j<map.length(); j++) {
                charMaps[i][j] = map.charAt(j);
            }
        }

        List<Integer> list = new LinkedList<>();
        for(int i=0; i<charMaps.length; i++) {
            for(int j=0; j<charMaps[i].length; j++) {
                if(charMaps[i][j] != 'X') {
                    dfs(charMaps, i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }

        if(list.isEmpty()) {
            return new int[]{-1};
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(char[][] charMaps, int x, int y) {
        count += charMaps[x][y] - '0';
        charMaps[x][y] = 'X';

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < charMaps.length && 0 <= ny && ny < charMaps[0].length
                    && charMaps[nx][ny] != 'X') {
                dfs(charMaps, nx, ny);
            }
        }
    }
}
