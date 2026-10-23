class Solution {
    void dfs(int r, int c, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        int[] dirR = {-1, 0, 1, 0};
        int[] dirC = {0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int nr = r + dirR[k];
            int nc = c + dirC[k];
            dfs(nr, nc, grid);
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }
}
