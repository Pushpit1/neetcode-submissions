class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] par = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = par[0] + dr[i];
                int nc = par[1] + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[nr][nc] = grid[par[0]][par[1]] + 1;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}
