package _2024년._6월.programmers.lv3;

public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int result = 0;
        int[][] prefixSum = new int[board.length+2][board[0].length+2];

        for(int i=0; i<skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            if(type == 1) {
                prefixSum[r1+1][c1+1] += -degree;
                prefixSum[r1+1][c2+2] += degree;
                prefixSum[r2+2][c1+1] += degree;
                prefixSum[r2+2][c2+2] += -degree;
            } else {
                prefixSum[r1+1][c1+1] += degree;
                prefixSum[r1+1][c2+2] += -degree;
                prefixSum[r2+2][c1+1] += -degree;
                prefixSum[r2+2][c2+2] += degree;
            }
        }

        for(int i=1; i<prefixSum.length; i++) {
            for(int j=1; j<prefixSum[i].length; j++) {
                prefixSum[i][j] += prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        for(int i=1; i<prefixSum.length-1; i++) {
            for(int j=1; j<prefixSum[i].length-1; j++) {
                if(prefixSum[i][j] + board[i-1][j-1] >= 1) {
                    result++;
                }
            }
        }

        return result;
    }
}
