
class Solution {

    int[][] dp;

    int memo(int i, int amount, int[] coins) {

        if (amount == 0) return 0;
        if (i == coins.length) return Integer.MAX_VALUE;

        if (dp[i][amount] != -1) return dp[i][amount];

        int take = Integer.MAX_VALUE;

        if (amount >= coins[i]) {
            int res = memo(i, amount - coins[i], coins);

            if (res != Integer.MAX_VALUE)
                take = 1 + res;
        }

        int skip = memo(i + 1, amount, coins);

        return dp[i][amount] = Math.min(take, skip);
    }

    public int coinChange(int[] coins, int amount) {

        dp = new int[coins.length][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = memo(0, amount, coins);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}