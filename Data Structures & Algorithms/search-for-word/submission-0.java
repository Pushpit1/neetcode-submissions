class Solution {
    boolean back(char[][] board, String word, int row, int col,
                 int k, boolean[][] visited) {

        int n = board.length;
        int m = board[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m) {
            return false;
        }

        if (visited[row][col] || board[row][col] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (back(board, word, nr, nc, k + 1, visited)) {
                visited[row][col] = false;
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (back(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}