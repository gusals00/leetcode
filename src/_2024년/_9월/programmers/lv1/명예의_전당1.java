package _2024년._9월.programmers.lv1;

import java.util.PriorityQueue;
import java.util.Queue;

public class 명예의_전당1 {
    public int[] solution(int k, int[] score) {
        Queue<Integer> queue = new PriorityQueue<>();
        int[] result = new int[score.length];

        for (int i=0; i<score.length; i++) {
            queue.add(score[i]);

            if(queue.size() > k) {
                queue.remove();
            }

            result[i] = queue.peek();
        }

        return result;
    }
}
