package _2024년._6월.programmers.lv3;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int result = 1;
        int prevOut = routes[0][1];
        for(int i=1; i<routes.length; i++) {
            if(routes[i][0] <= prevOut) {
                prevOut = Math.min(routes[i][1], prevOut);
            } else {
                result++;
                prevOut = routes[i][1];
            }
        }

        return result;
    }
}
