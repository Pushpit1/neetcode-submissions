class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        boolean[] vis = new boolean[n];

        pq.offer(new int[]{0, 0});

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            int[] curr = pq.poll();

            int dist = curr[0];
            int idx = curr[1];

            if (vis[idx]) {
                continue;
            }

            vis[idx] = true;
            sum += dist;
            count++;

            for (int i = 0; i < n; i++) {

                if (!vis[i]) {

                    int x1 = points[idx][0];
                    int y1 = points[idx][1];

                    int x2 = points[i][0];
                    int y2 = points[i][1];

                    int cost = Math.abs(x1 - x2)
                             + Math.abs(y1 - y2);

                    pq.offer(new int[]{cost, i});
                }
            }
        }

        return sum;
    }
}