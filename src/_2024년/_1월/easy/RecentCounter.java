package _2024년._1월.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t - 3000) {
            queue.remove();
        }

        return queue.size();
    }
}
