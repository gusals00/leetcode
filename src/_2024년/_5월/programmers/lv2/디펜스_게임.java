package _2024년._5월.programmers.lv2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스_게임 {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> queue = new PriorityQueue<>();

        if(k == enemy.length) {
            return enemy.length;
        }

        for (int i=0; i<enemy.length; i++) {
            queue.add(enemy[i]);

            if(queue.size() > k) {
                n -= queue.remove();
                if(n < 0) {
                    return i;
                }
            }
        }

        return enemy.length;
    }
}
