package _2024년._5월.programmers.lv2;

import java.util.Arrays;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col-1] == o2[col-1])
                return o2[0] - o1[0];
            return o1[col-1] - o2[col-1];
        });

        int result = 0;
        for(int i=row_begin-1; i<row_end; i++) {
            int sum = 0;
            for(int j=0; j<data[i].length; j++) {
                sum += data[i][j] % (i+1);
            }

            result = result ^ sum;
        }

        return result;
    }
}
