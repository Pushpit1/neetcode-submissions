
class Solution {
    int[][] memo;

    int f(int[] prices, int i, int hold) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i][hold] != -1) {
            return memo[i][hold];
        }

        if (hold == 0) {
            int buy = -prices[i] + f(prices, i + 1, 1);
            int skip = f(prices, i + 1, 0);

            memo[i][0] = Math.max(buy, skip);
        } else {
            int sell = prices[i] + f(prices, i + 2, 0);
            int skip = f(prices, i + 1, 1);

            memo[i][1] = Math.max(sell, skip);
        }

        return memo[i][hold];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return f(prices, 0, 0);
    }
}
