
class Solution {
    public int maxProfit(int[] prices) {
        int prev = 0;
        int cur = 1;
        int maxprofit = 0;

        while (cur < prices.length) {
            if (prices[cur] > prices[prev]) {
                maxprofit = Math.max(
                    maxprofit, prices[cur] - prices[prev]
                );
            } else {
                prev = cur;
            }

            cur++;
        }

        return maxprofit;
    }
}
