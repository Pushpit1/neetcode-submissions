class Solution {
     int dfs(int r, int c, int [][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (r < 0 || r >= n || c < 0 || c >= m
                || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int[] dirR = {-1, 0, 1, 0};
        int[] dirC = {0, -1, 0, 1};
        int area = 1 ; 

        for (int k = 0; k < 4; k++) {
            int nr = r + dirR[k];
            int nc = c + dirC[k];
            area+= dfs(nr, nc, grid);
        }
        return area ;
    }
    public int maxAreaOfIsland(int[][] grid) {
         if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0; ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea ,area );
                }
            }
        }

        return maxArea;
    }
}
