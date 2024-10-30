package _2024년._10월.programmers.lv1;

import java.util.Arrays;

public class 공원 {
    public int solution(int[] mats, String[][] park) {
        int result = -1;
        Arrays.sort(mats);
        int parkRows = park.length;
        int parkCols = park[0].length;

        for(int i=0; i<mats.length; i++) {
            for(int j = 0; j< parkRows; j++) {
                for(int k = 0; k< parkCols; k++) {
                    if(park[j][k].equals("-1")) {
                        boolean flag = false;
                        for(int l=j; l<j+mats[i]; l++) {
                            for(int m=k; m<k+mats[i]; m++) {
                                if(l >= parkRows || m >= parkCols || !park[l][m].equals("-1")) {
                                    flag = true;
                                    break;
                                }
                            }
                            if(flag) {
                                break;
                            }
                        }
                        if(!flag) {
                            result = Math.max(result, mats[i]);
                        }
                    }
                }
            }
        }

        return result;
    }
}
