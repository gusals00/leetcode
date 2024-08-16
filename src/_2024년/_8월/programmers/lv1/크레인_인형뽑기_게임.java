package _2024년._8월.programmers.lv1;

import java.util.ArrayDeque;
import java.util.Deque;

public class 크레인_인형뽑기_게임 {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int move : moves) {
            for(int i=0; i<board.length; i++) {
                if(board[i][move-1] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[i][move-1]) {
                        stack.pop();
                        result += 2;
                    } else {
                        stack.push(board[i][move-1]);
                    }

                    board[i][move-1] = 0;
                    break;
                }
            }
        }

        return result;
    }
}
