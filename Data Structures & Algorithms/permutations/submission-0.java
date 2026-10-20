
class Solution {

    void back(List<Integer> b, List<List<Integer>> ans,
              int[] nums, boolean[] used) {

        if (b.size() == nums.length) {
            ans.add(new ArrayList<>(b));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            b.add(nums[i]);
            used[i] = true;

            back(b, ans, nums, used);

        
            b.remove(b.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        back(b, ans, nums, used);

        return ans;
    }
}
