package _2024년._5월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> firstQueue = new ArrayDeque<>();
        Queue<Integer> secondQueue = new ArrayDeque<>();
        int result = 0;
        long totalSum = 0;
        long queue1Sum = 0;

        for(int i=0; i<queue1.length; i++) {
            queue1Sum += queue1[i];
            totalSum += queue1[i] + queue2[i];
            firstQueue.add(queue1[i]);
            secondQueue.add(queue2[i]);
        }

        if(totalSum % 2 != 0) {
            return -1;
        }

        long target = totalSum/2;
        while(result <= queue1.length*4) {
            if(queue1Sum == target) {
                return result;
            } else if(queue1Sum > target) {
                int remove = firstQueue.remove();
                secondQueue.add(remove);
                queue1Sum -= remove;
            } else {
                int remove = secondQueue.remove();
                firstQueue.add(remove);
                queue1Sum += remove;
            }

            result++;
        }

        return -1;
    }
}
