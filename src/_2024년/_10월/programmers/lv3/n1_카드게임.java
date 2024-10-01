package _2024년._10월.programmers.lv3;

import java.util.HashSet;
import java.util.Set;

public class n1_카드게임 {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int round = 1;

        Set<Integer> hand = new HashSet<>();
        Set<Integer> draw = new HashSet<>();
        int index = 0;
        for(; index<n/3; index++) {
            hand.add(cards[index]);
        }

        while(index < n) {
            boolean flag = false;
            draw.add(cards[index]);
            draw.add(cards[index+1]);

            for (int i : hand) {
                if(hand.contains(n+1 - i)) {
                    hand.remove(i);
                    hand.remove(n+1 - i);
                    flag = true;
                    break;
                }
            }

            if(!flag && coin >= 1) {
                for (int i : draw) {
                    if(hand.contains(n+1 - i)) {
                        draw.remove(i);
                        hand.remove(n+1 - i);
                        coin--;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag && coin >= 2) {
                for (int i : draw) {
                    if(draw.contains(n+1 - i)) {
                        draw.remove(i);
                        draw.remove(n+1 - i);
                        coin -= 2;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) {
                break;
            }

            index += 2;
            round++;
        }

        return round;
    }
}
