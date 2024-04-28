package _2024년._4월.programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 호텔_대실 {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, Comparator.comparing(time -> time[0]));
        PriorityQueue<int[]> rooms = new PriorityQueue<>(Comparator.comparingInt(room -> room[1]));

        for (String[] str : book_time) {
            String[] start = str[0].split(":");
            String[] end = str[1].split(":");

            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;

            if(rooms.isEmpty()) {
                rooms.add(new int[]{startTime, endTime});
            } else {
                int[] peek = rooms.peek();

                if(startTime >= peek[1]) {
                    rooms.remove();
                }
                rooms.add(new int[]{startTime, endTime});
            }
        }

        return rooms.size();
    }
}
