
class Solution {
    void back(int[] candidates, int target, int sum, int start,
              List<Integer> b, List<List<Integer>> ans) {

        if (sum == target) {
            ans.add(new ArrayList<>(b));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
    continue;
}

            b.add(candidates[i]);

            back(candidates, target, sum + candidates[i], i+1, b, ans);

            b.remove(b.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        back(candidates, target, 0, 0, b, ans);

        return ans;
    }
}
