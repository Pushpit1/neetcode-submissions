
class Solution {
    int[][] dp;

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new int[nums.length][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, target, nums);
    }

    boolean solve(int i, int target, int[] nums) {

        if (target == 0) return true;

        if (i == nums.length) return false;

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        // Skip current element
        boolean skip = solve(i + 1, target, nums);

        // Take current element
        boolean take = false;

        if (nums[i] <= target) {
            take = solve(i + 1, target - nums[i], nums);
        }

        boolean ans = take || skip;

        dp[i][target] = ans ? 1 : 0;

        return ans;
    }
}
