package _2024년._10월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new ArrayDeque<>();
        int sum = 0;
        int time = 0;
        for(int i=0; i<truck_weights.length; i++) {
            while(true) {
                if (queue.size() < bridge_length && sum+truck_weights[i] <= weight) {
                    queue.add(new Truck(truck_weights[i], time));
                    sum += truck_weights[i];
                    time++;
                    break;
                } else if (!queue.isEmpty() && time - queue.peek().time >= bridge_length) {
                    sum -= queue.remove().weight;
                } else {
                    time++;
                }
            }
        }

        while(!queue.isEmpty()) {
            if(time - queue.peek().time >= bridge_length) {
                queue.remove();
            }

            time++;
        }

        return time;
    }

    private static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}
