package _2024년._9월.programmers.lv1;

public class 푸드_파이트_대회 {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++) {
            if(food[i]/2 == 0)
                continue;

            sb.append(String.valueOf(i).repeat(food[i]/2));
        }

        String back = new StringBuilder(sb.toString()).reverse().toString();
        return sb + "0" + back;
    }
}
