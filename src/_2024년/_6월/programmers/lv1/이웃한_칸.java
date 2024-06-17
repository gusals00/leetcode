package _2024년._6월.programmers.lv1;

public class 이웃한_칸 {
    public int solution(String[][] board, int h, int w) {
        int result = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        String color = board[h][w];

        for(int i=0; i<4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];

            if(0 <= x && x < board.length && 0 <= y && y < board[0].length
            && board[x][y].equals(color)) {
                result++;
            }
        }

        return result;
    }
}
