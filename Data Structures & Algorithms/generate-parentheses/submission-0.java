
class Solution {
    void back(int n, int open, int close,
              String current, List<String> ans) {

        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        if (open < n) {
            back(n, open + 1, close, current + "(", ans);
        }

        if (close < open) {
            back(n, open, close + 1, current + ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        back(n, 0, 0, "", ans);

        return ans;
    }
}
