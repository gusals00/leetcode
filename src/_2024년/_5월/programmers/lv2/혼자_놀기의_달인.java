package _2024년._5월.programmers.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 혼자_놀기의_달인 {
    public int solution(int[] cards) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        boolean[] visited = new boolean[cards.length];

        for(int i=0; i<cards.length; i++) {
            int count = dfs(cards, visited, i, 0);
            queue.add(count);
        }

        if(queue.size() == 1) {
            return 0;
        } else {
            return queue.remove() * queue.remove();
        }
    }

    private int dfs(int[] cards, boolean[] visited, int index, int count) {
        if(visited[index]) {
            return count;
        }

        visited[index] = true;
        return dfs(cards, visited, cards[index]-1, count+1);
    }
}
