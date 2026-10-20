class Solution {
    void back(int i , List<Integer> b, List<List<Integer>> ans, int[] nums) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(b));
            return;
        }

        b.add(nums[i]);
        back(i + 1, b, ans, nums);

        b.remove(b.size() - 1);

        back(i + 1, b, ans, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        back(0, b, ans, nums);

        return ans;
    }
}
