package _2023년._12월.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    private static final int SUDOKU_SIZE = 9;
    Set<Character> set = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<SUDOKU_SIZE; i++) {
            if(!validSudoku(board, i, 0, i, SUDOKU_SIZE-1)) {
                return false;
            }
            if(!validSudoku(board, 0, i, SUDOKU_SIZE-1, i)) {
                return false;
            }
        }

        for(int i=0; i<SUDOKU_SIZE; i+=3) {
            for(int j=0; j<SUDOKU_SIZE; j+=3) {
                if(!validSudoku(board, i, j, i+2, j+2)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validSudoku(char[][] board, int x, int y, int x2, int y2) {
        set.clear();

        for(int i=x; i<=x2; i++) {
            for(int j=y; j<=y2; j++) {
                if(board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }
}
