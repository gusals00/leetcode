package _2024년._6월.programmers.lv3;

public class 미로_탈출_명령어 {
    char[] dir = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String result = "";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = getDistance(x, y, r, c);
        if((k - distance) % 2 == 1 || k < distance) {
            return "impossible";
        }

        dfs(x, y, n, m, r, c, k, new StringBuilder());

        return result;
    }

    private void dfs(int x, int y, int n, int m, int r, int c, int k, StringBuilder sb) {
        if(!result.isEmpty()) {
            return;
        }
        if(sb.length() == k && x == r && y == c) {
            result = sb.toString();
            return;
        } else if(sb.length() == k) {
            return;
        }
        if(k - sb.length() < getDistance(x, y, r, c)) {
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(1 <= nx && nx <= n && 1 <= ny && ny <= m) {
                sb.append(dir[i]);
                dfs(nx, ny, n, m, r, c, k, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    private int getDistance(int x, int y, int r, int c) {
        return Math.abs(x-r) + Math.abs(y-c);
    }
}
