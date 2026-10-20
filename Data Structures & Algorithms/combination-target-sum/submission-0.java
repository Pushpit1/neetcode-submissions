
class Solution {
    void back(int[] nums, int target, int sum, int start,
              List<Integer> b, List<List<Integer>> ans) {

        if (sum == target) {
            ans.add(new ArrayList<>(b));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            b.add(nums[i]);

            back(nums, target, sum + nums[i], i, b, ans);

            b.remove(b.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        back(nums, target, 0, 0, b, ans);

        return ans;
    }
}
