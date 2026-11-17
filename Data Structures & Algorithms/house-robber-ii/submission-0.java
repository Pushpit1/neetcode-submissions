
class Solution {

    int[] memo;

    int robber(int start, int end, int[] nums) {

        if (start > end) return 0;

        if (memo[start] != -1) {
            return memo[start];
        }

        int take = nums[start] + robber(start + 2, end, nums);
        int skip = robber(start + 1, end, nums);

        memo[start] = Math.max(take, skip);

        return memo[start];
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) return nums[0];

        memo = new int[n];
        Arrays.fill(memo, -1);

        int first = robber(0, n - 2, nums);

        memo = new int[n];
        Arrays.fill(memo, -1);

        int second = robber(1, n - 1, nums);

        return Math.max(first, second);
    }
}
