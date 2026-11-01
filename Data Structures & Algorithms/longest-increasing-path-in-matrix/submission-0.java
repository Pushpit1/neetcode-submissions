class Solution {
    int length(int[][] memo, int row, int col, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (row > n - 1 || row < 0 || col > m - 1 || col < 0) {
            return 0;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        int up = 0, down = 0, left = 0, right = 0;

        if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
            up = length(memo, row - 1, col, matrix);
        }

        if (row < n - 1 && matrix[row + 1][col] > matrix[row][col]) {
            down = length(memo, row + 1, col, matrix);
        }

        if (col > 0 && matrix[row][col - 1] > matrix[row][col]) {
            left = length(memo, row, col - 1, matrix);
        }

        if (col < m - 1 && matrix[row][col + 1] > matrix[row][col]) {
            right = length(memo, row, col + 1, matrix);
        }

        memo[row][col] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
        return memo[row][col];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, length(memo, i, j, matrix));
            }
        }
        return ans;
    }
}
