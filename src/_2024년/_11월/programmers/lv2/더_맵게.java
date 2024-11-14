package _2024년._11월.programmers.lv2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.add(s);
        }

        int result = 0;
        while(pq.size() >= 2 && pq.peek() < K) {
            int first = pq.remove();
            int second = pq.remove();
            pq.add(first + second*2);

            result++;
        }

        if(pq.peek() < K) {
            return -1;
        } else {
            return result;
        }
    }
}
