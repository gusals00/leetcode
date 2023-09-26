package _2023년._9월.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            if(!check(board, i, 0, i, 8))
                return false;
            if(!check(board, 0, i, 8, i))
                return false;
        }

        for(int i=0; i<9; i+=3) {
            for(int j=0; j<9; j+=3) {
                if(!check(board, i, j, i+2, j+2))
                    return false;
            }
        }

        return true;
    }

    private boolean check(char[][] board, int x, int y, int x2, int y2) {
        Set<Character> set = new HashSet<>();

        for(int i=x; i<=x2; i++) {
            for(int j=y; j<=y2; j++) {
                if(board[i][j]!='.' && !set.add(board[i][j]))
                    return false;
            }
        }

        return true;
    }
}
