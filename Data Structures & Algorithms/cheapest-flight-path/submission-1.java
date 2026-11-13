class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[][] dist = new int[n][K + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int u = curr[1];
            int stops = curr[2];

            if (u == dst) return cost;

            if (stops == K + 1) continue;

            if (cost > dist[u][stops]) continue;

            for (int[] next : adj.get(u)) {

                int v = next[0];
                int price = next[1];

                int newCost = cost + price;
                int newStops = stops + 1;

                if (newCost < dist[v][newStops]) {

                    dist[v][newStops] = newCost;

                    pq.offer(new int[]{
                        newCost, v, newStops
                    });
                }
            }
        }

        return -1;
    }
}