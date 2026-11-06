class Solution {
    int mem(int i, int[] memo, int[] cost) {
        if (i >= cost.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        return memo[i] = cost[i] + Math.min(mem(i + 1, memo, cost), mem(i + 2, memo, cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);

        return Math.min(mem(0, memo, cost), mem(1, memo, cost));
    }
}