
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char num = board[i][j];

                if (num == '.') {
                    continue;
                }

                // 1. Check the row
                for (int k = 0; k < m; k++) {
                    if (k != j && board[i][k] == num) {
                        return false;
                    }
                }

                // 2. Check the column
                for (int k = 0; k < n; k++) {
                    if (k != i && board[k][j] == num) {
                        return false;
                    }
                }

                int startRow = (i / 3) * 3;
                int startCol = (j / 3) * 3;

                for (int r = startRow; r < startRow + 3; r++) {
                    for (int c = startCol; c < startCol + 3; c++) {
                        if ((r != i || c != j) && board[r][c] == num) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
