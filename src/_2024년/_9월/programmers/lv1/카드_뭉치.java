package _2024년._9월.programmers.lv1;

public class 카드_뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Index = 0;
        int card2Index = 0;

        for(int i=0; i<goal.length; i++) {
            if(card1Index < cards1.length && cards1[card1Index].equals(goal[i])) {
                card1Index++;
            } else if(card2Index < cards2.length && cards2[card2Index].equals(goal[i])) {
                card2Index++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
