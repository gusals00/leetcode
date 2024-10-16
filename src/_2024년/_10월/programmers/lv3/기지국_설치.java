package _2024년._10월.programmers.lv3;

public class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int result = 0;
        int stationStart = 0;
        int stationEnd = 0;
        int currentIndex = 1;

        for(int i=0; i<stations.length; i++) {
            stationStart = stations[i]-w;
            stationEnd = stations[i]+w;
            if(currentIndex < stationStart) {
                result += (stationStart-currentIndex)/(2*w+1);
                if((stationStart-currentIndex)%(2*w+1) != 0) {
                    result++;
                }
            }

            currentIndex = stationEnd+1;
        }

        if(currentIndex <= n) {
            result += (n-currentIndex+1)/(2*w+1);
            if((n-currentIndex+1)%(2*w+1) != 0) {
                result++;
            }
        }

        return result;
    }
}
