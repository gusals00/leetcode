package _2024년._8월.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 가장_많이_받은_선물 {
    public int solution(String[] friends, String[] gifts) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++) {
            map.put(friends[i], i);
        }

        int[][] arr = new int[friends.length][friends.length];
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            arr[map.get(split[0])][map.get(split[1])]++;
        }

        int[] giftIndex = new int[friends.length];
        for(int i=0; i<giftIndex.length; i++) {
            int giftCount = 0;
            int receiveCount = 0;
            for(int j=0; j<friends.length; j++) {
                giftCount += arr[i][j];
                receiveCount += arr[j][i];
            }

            giftIndex[i] = giftCount - receiveCount;
        }

        for(int i=0; i<friends.length; i++) {
            int receive = 0;
            for(int j=0; j<friends.length; j++) {
                if(i == j)
                    continue;

                if((arr[i][j] > arr[j][i]) || (arr[i][j] == arr[j][i] && giftIndex[i] > giftIndex[j])) {
                    receive++;
                }
            }

            result = Math.max(result, receive);
        }

        return result;
    }
}
