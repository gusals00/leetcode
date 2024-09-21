package _2024년._9월.programmers.lv2;

import java.util.*;

public class 충돌위험_찾기 {
    public int solution(int[][] points, int[][] routes) {
        Queue<Point> queue = new ArrayDeque<>();
        Map<Integer, Point> map = new HashMap<>();
        int result = 0;

        for(int i=0; i<points.length; i++) {
            map.put(i+1, new Point(points[i][0], points[i][1]));
        }

        for (int[] route : routes) {
            Point point = map.get(route[0]);
            Point newPoint = new Point(point.r, point.c);
            int[][] destination = new int[route.length-1][2];
            for(int i=1; i<route.length; i++) {
                Point p = map.get(route[i]);
                destination[i-1][0] = p.r;
                destination[i-1][1] = p.c;
            }
            newPoint.destination = destination;
            queue.add(newPoint);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            Map<String, Integer> count = new HashMap<>();

            for(int i=0; i<size; i++) {
                Point remove = queue.remove();

                String key = remove.r + "," + remove.c;
                count.put(key, count.getOrDefault(key, 0) + 1);

                int[] dest = remove.destination[remove.index];
                if(remove.r == dest[0] && remove.c == dest[1]) {
                    if(remove.index < remove.destination.length-1) {
                        remove.index++;
                        dest = remove.destination[remove.index];
                    } else {
                        continue;
                    }
                }

                if(remove.r != dest[0]) {
                    if(remove.r > dest[0]) {
                        remove.r--;
                    } else {
                        remove.r++;
                    }
                } else if(remove.c != dest[1]) {
                    if(remove.c > dest[1]) {
                        remove.c--;
                    } else {
                        remove.c++;
                    }
                }

                queue.add(remove);
            }

            for (int value : count.values()) {
                if(value >= 2) {
                    result++;
                }
            }
        }

        return result;
    }
}

class Point {
    int r;
    int c;
    int[][] destination;
    int index = 0;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
