class Solution {
    Map<String, Integer> dp = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return back(nums, target, 0, 0);
    }

    private int back(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = i + "," + sum;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int add = back(nums, target, i + 1, sum + nums[i]);
        int subtract = back(nums, target, i + 1, sum - nums[i]);

        dp.put(key, add + subtract);

        return add + subtract;
    }
}