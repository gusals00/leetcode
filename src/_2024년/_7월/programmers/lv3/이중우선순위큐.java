package _2024년._7월.programmers.lv3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        int size = 0;

        for (String operation : operations) {
            String[] s = operation.split(" ");
            String command = s[0];
            int value = Integer.parseInt(s[1]);

            if("I".equals(command)) {
                size++;
                min.add(value);
                max.add(value);
            } else {
                if(size > 0) {
                    size--;

                    if(size == 0) {
                        min.clear();
                        max.clear();
                    }
                    else if(value > 0) {
                        if(!max.isEmpty()) {
                            max.remove();
                        }
                    } else {
                        if (!min.isEmpty()) {
                            min.remove();
                        }
                    }
                }
            }
        }

        if(size > 1) {
            return new int[]{max.remove(), min.remove()};
        } else {
            return new int[]{0, 0};
        }
    }
}
