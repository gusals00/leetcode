package _2024년._1월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();
        int n = senate.length();
        for(int i = 0; i< n; i++) {
            if(senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()) {
            if(radiant.peek() < dire.peek()) {
                radiant.add(n++);
            } else {
                dire.add(n++);
            }
            radiant.remove();
            dire.remove();
        }

        if(radiant.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }
}
