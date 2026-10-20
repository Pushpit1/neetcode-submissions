class Solution {
    void back(int start, List<Integer> b,
              List<List<Integer>> ans, int[] nums) {

        ans.add(new ArrayList<>(b));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            b.add(nums[i]);

            back(i + 1, b, ans, nums);

            b.remove(b.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        back(0, b, ans, nums);

        return ans;
    }
}
