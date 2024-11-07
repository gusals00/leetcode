package _2024년._11월.programmers.lv1;

public class 다트_게임 {
    public int solution(String dartResult) {
        int[] game = new int[3];
        int current = 0;

        for(int i=0; i<dartResult.length(); ) {
            int score = dartResult.charAt(i++) - '0';
            if(Character.isDigit(dartResult.charAt(i))) {
                score = score*10 + dartResult.charAt(i++) - '0';
            }
            char bonus = dartResult.charAt(i++);

            char option = 'x';
            if(i < dartResult.length() && !Character.isDigit(dartResult.charAt(i))) {
                option = dartResult.charAt(i++);
            }

            game[current] = score;
            if(bonus == 'D') {
                game[current] = game[current] * game[current];
            } else if(bonus == 'T') {
                game[current] = game[current] * game[current] * game[current];
            }

            if(option != 'x') {
                if(option == '*') {
                    game[current] *= 2;
                    if(current != 0) {
                        game[current-1] *= 2;
                    }
                } else {
                    game[current] *= -1;
                }
            }

            current++;
        }

        return game[0] + game[1] + game[2];
    }
}
