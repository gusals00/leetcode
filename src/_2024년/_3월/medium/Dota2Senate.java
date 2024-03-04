package _2024년._3월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();

        int n = senate.length();
        for(int i=0; i<n; i++) {
            if(senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        while(!r.isEmpty() && !d.isEmpty()) {
            if(r.remove() < d.remove()) {
                r.add(n++);
            } else {
                d.add(n++);
            }
        }

        if(r.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }
}
