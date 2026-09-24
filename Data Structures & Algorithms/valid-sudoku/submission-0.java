class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.')
                    continue;

                // Check row
                for(int k = 0; k < 9; k++) {
                    if(k != j && board[i][j] == board[i][k])
                        return false;
                }

                // Check column
                for(int k = 0; k < 9; k++) {
                    if(k != i && board[i][j] == board[k][j])
                        return false;
                }

                // Check 3 x 3 box
                int rowStart = (i / 3) * 3;
                int colStart = (j / 3) * 3;

                for(int r = rowStart; r < rowStart + 3; r++) {
                    for(int c = colStart; c < colStart + 3; c++) {

                        if((r != i || c != j) && board[i][j] == board[r][c])
                            return false;
                    }
                }
            }
        }

        return true;
    }
}