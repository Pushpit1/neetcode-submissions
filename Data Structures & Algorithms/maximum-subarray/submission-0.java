class Solution {
    public int maxSubArray(int[] nums) {

        int smax = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            smax = Math.max(nums[i], smax + nums[i]);

            ans = Math.max(ans, smax);
        }

        return ans;
    }
}