package _2024년._6월.programmers.lv1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int maxCol = 0;
        int minRow = 0;

        for(int i=0; i< sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            maxCol = Math.max(maxCol, max);
            minRow = Math.max(minRow, min);
        }

        return maxCol * minRow;
    }
}
