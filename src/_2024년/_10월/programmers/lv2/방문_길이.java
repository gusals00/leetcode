package _2024년._10월.programmers.lv2;

public class 방문_길이 {
    public int solution(String dirs) {
        int result = 0;
        boolean[][][] visited = new boolean[11][11][4];
        char[] chars = dirs.toCharArray();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 5;
        int y = 5;
        int dir = 0;

        for(int i=0; i<chars.length; i++) {
            if(chars[i] == 'U') {
                dir = 0;
            } else if(chars[i] == 'R') {
                dir = 1;
            } else if(chars[i] == 'D') {
                dir = 2;
            } else {
                dir = 3;
            }

            x += dx[dir];
            y += dy[dir];
            if(0 > x || x > 10 || 0 > y || y > 10) {
                x -= dx[dir];
                y -= dy[dir];
                continue;
            }
            if(visited[x][y][dir]) {
                continue;
            }
            visited[x][y][dir] = true;
            visited[x-dx[dir]][y-dy[dir]][(dir+2)%4] = true;

            result++;
        }

        return result;
    }
}
