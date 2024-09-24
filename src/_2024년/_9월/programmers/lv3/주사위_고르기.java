package _2024년._9월.programmers.lv3;

import java.util.*;

public class 주사위_고르기 {
    private int max = -1;
    private int[] result;

    public int[] solution(int[][] dice) {
        result = new int[dice.length/2];
        choice(0, 0, new ArrayList<>(), dice);

        return result;
    }

    private void choice(int count, int start, List<Integer> list, int[][] dice) {
        if(count == dice.length/2) {
            int score = getScore(dice, list);
            if(max < score) {
                max = score;

                for(int i=0; i<list.size(); i++) {
                    result[i] = list.get(i) + 1;
                }
            }
            return;
        }

        for(int i = start; i<dice.length; i++) {
            list.add(i);
            choice(count+1, i+1, list, dice);
            list.remove(list.size()-1);
        }
    }

    private int getScore(int[][] dice, List<Integer> choice) {
        int[][] diceA = new int[dice.length/2][6];
        int[][] diceB = new int[dice.length/2][6];
        Set<Integer> set = new HashSet<>(choice);
        int a=0, b=0;
        for(int i=0; i<dice.length; i++) {
            if(set.contains(i)) {
                diceA[a++] = dice[i];
            } else {
                diceB[b++] = dice[i];
            }
        }

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        makeList(0, listA, diceA, 0);
        makeList(0, listB, diceB, 0);

        int count = 0;
        Collections.sort(listB);
        for(int i=0; i<listA.size(); i++) {
            int value = listA.get(i);

            int start = 0;
            int end = listB.size();
            while(start + 1 < end) {
                int mid = (start + end) / 2;

                if(listB.get(mid) < value) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            count += start;
        }

        return count;
    }

    private void makeList(int count, List<Integer> list, int[][] dice, int sum) {
        if(count == dice.length) {
            list.add(sum);
            return;
        }

        for(int i=0; i<6; i++) {
            makeList(count+1, list, dice, sum+dice[count][i]);
        }
    }
}
