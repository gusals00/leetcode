package _2024년._6월.programmers.lv2;

public class 땅따먹기 {
    int solution(int[][] land) {
        int result = 0;

        for(int i=1; i<land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        for(int i=0; i<4; i++) {
            result = Math.max(result, land[land.length-1][i]);
        }

        return result;
    }
}
