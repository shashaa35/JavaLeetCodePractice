package leetcode;

import java.util.ArrayList;
import java.util.Collections;

//https://leetcode.com/problems/valid-sudoku/solution/
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return isValidSquares(board) && isValidRows(board) && isValidCols(board);
    }

    private boolean isValidRows(char[][] board) {
        for (int i=0;i<9;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for (int j=0;j<9;j++){
                if (board[i][j] != '.') {
                    row.add(board[i][j]-'0');
                }
            }
            if (!isValidSequence(row))
                return false;
        }
        return true;
    }

    private boolean isValidCols(char[][] board) {
        for (int j=0;j<9;j++){
            ArrayList<Integer> col = new ArrayList<>();
            for (int i=0;i<9;i++){
                if (board[i][j] != '.') {
                    col.add(board[i][j]-'0');
                }
            }
            if (!isValidSequence(col))
                return false;
        }
        return true;
    }

    private boolean isValidSquares(char[][] board) {
        for (int i=0;i<9;i+=3){
            for (int j=0;j<9;j+=3){
                if (!isValidSquare(board, i, j))
                    return false;
            }
        }
        return true;
    }

    private boolean isValidSquare(char[][] board, int startRow, int startCol) {
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i=startRow;i<startRow+3;i++){
            for (int j=startCol;j<startCol+3;j++){
                if (board[i][j] != '.') {
                    seq.add(board[i][j]-'0');
                }
            }
        }
        return isValidSequence(seq);
    }

    private boolean isValidSequence(ArrayList<Integer> seq) {
        if(seq.size()>0 && (seq.get(0) <1 || seq.get(0)>9))
            return false;

        Collections.sort(seq);

        for (int i=1;i<seq.size();i++) {
            if (seq.get(i).equals(seq.get(i - 1)) || seq.get(i) <1 || seq.get(i)>9)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        IsValidSudoku obj = new IsValidSudoku();
        System.out.println(obj.isValidSudoku(board));
    }
}
