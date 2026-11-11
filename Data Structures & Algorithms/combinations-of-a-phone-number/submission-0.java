class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        ArrayList<char[]> list = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            int a = digits.charAt(i) - '0';
            char[] x = map[a].toCharArray();
            list.add(x);
        }

        solve(list, 0, "", ans);

        return ans;
    }

    void solve(ArrayList<char[]> list, int index,
               String curr, List<String> ans) {

        if (index == list.size()) {
            ans.add(curr);
            return;
        }

        for (char ch : list.get(index)) {
            solve(list, index + 1, curr + ch, ans);
        }
    }
}
