package _2024년._4월.programmers.lv2;


import java.util.Arrays;

public class 광물_캐기 {
    public int solution(int[] picks, String[] minerals) {
        int result = 0;
        int totalPick = picks[0] + picks[1] + picks[2];

        int[][] score = new int[minerals.length/5 + 1][3];

        for(int i=0; i< minerals.length && totalPick>0; i+=5) {
            int dia = 0;
            int iron = 0;
            int stone = 0;

            for(int j=i; j<i+5; j++) {
                if(j == minerals.length)
                    break;

                String mineral = minerals[j];
                if(mineral.equals("diamond")) {
                    dia += 1;
                    iron += 5;
                    stone += 25;
                } else if(mineral.equals("iron")) {
                    dia += 1;
                    iron += 1;
                    stone += 5;
                } else {
                    dia += 1;
                    iron += 1;
                    stone += 1;
                }
            }

            score[i/5][0] = dia;
            score[i/5][1] = iron;
            score[i/5][2] = stone;
            totalPick--;
        }

        Arrays.sort(score, (o1, o2) -> o2[2] - o1[2]);

        int pick = 0;
        for(int i=0; i<score.length; i++) {
            while(pick < 3 && picks[pick] == 0)
                pick++;
            if(pick == 3)
                break;

            result += score[i][pick];
            picks[pick]--;
        }

        return result;
    }
}
