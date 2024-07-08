package _2024년._7월.programmers.lv2;

public class 가장_큰_정사각형_찾기 {
    public int solution(int[][] board) {
        int length = 0;

        if(board.length < 2 || board[0].length < 2) {
            if(!isAllZero(board)) {
                length = 1;
            }
        }

        for(int i=1; i<board.length; i++) {
            for(int j=1; j<board[i].length; j++) {
                if(board[i][j] != 0) {
                    board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;

                    length = Math.max(board[i][j], length);
                }
            }
        }

        return length * length;
    }

    private boolean isAllZero(int[][] board) {
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[0].length; j++) {
                if(board[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
