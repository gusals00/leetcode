package _2024년._3월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if(asteroid > 0) {
                stack.push(asteroid);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }


                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
                if(stack.peek() + asteroid == 0) {
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = stack.removeLast();
        }

        return result;
    }
}
