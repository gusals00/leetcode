package _2024년._10월.programmers.lv2;

public class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++) {
            map[i] = board[i].toCharArray();
        }

        boolean[][] checked = new boolean[m][n];
        int result = 0;
        while(checkBlock(m, n, map, checked)) {
            result += deleteBlock(m, n, map, checked);
            dropBlock(m, n, map);
            checked = new boolean[m][n];
        }

        return result;
    }

    private boolean checkBlock(int m, int n, char[][] map, boolean[][] checked) {
        boolean flag = false;

        for(int i = 0; i< m -1; i++) {
            for(int j = 0; j< n -1; j++) {
                char check = map[i][j];
                if(check == '.') {
                    continue;
                }

                if(map[i][j+1] == check && map[i+1][j] == check
                && map[i+1][j+1] == check) {
                    checked[i][j] = true;
                    checked[i][j+1] = true;
                    checked[i+1][j] = true;
                    checked[i+1][j+1] = true;
                    flag = true;
                }
            }
        }

        return flag;
    }

    private int deleteBlock(int m, int n, char[][] map, boolean[][] checked) {
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(checked[i][j]) {
                    map[i][j] = '.';
                    count++;
                }
            }
        }

        return count;
    }

    private void dropBlock(int m, int n, char[][] map) {
        for(int i=0; i<n; i++) {
            for(int j=m-1; j>=0; j--) {
                if(map[j][i] == '.') {
                    for(int k=j-1; k>=0; k--) {
                        if(map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
