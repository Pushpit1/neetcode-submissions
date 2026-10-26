class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int j = 1; j < nums.length; j++) {
            int product = 1;

            int prevmax = max;
            int prevmin = min;

            max = Math.max(nums[j], Math.max(nums[j] * prevmax, nums[j] * prevmin));
            min = Math.min(nums[j], Math.min(nums[j] * prevmax, nums[j] * prevmin));

            ans  =Math.max(ans ,Math.max(max , min)) ;
        }

        return ans;
    }
}
