class Solution {
    Boolean[][] memo;

    boolean solve(int i, int j, String s, String p) {

        // Pattern exhausted
        if (j == p.length()) {
            return i == s.length();
        }

        // String exhausted
        if (i == s.length()) {
            while (j < p.length()) {
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    j += 2;
                } else {
                    return false;
                }
            }
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean match = (s.charAt(i) == p.charAt(j) ||
                         p.charAt(j) == '.');

        boolean ans;

        // Next pattern character is *
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Choice 1: Zero occurrences
            boolean skip = solve(i, j + 2, s, p);

            // Choice 2: One or more occurrences
            boolean take = match && solve(i + 1, j, s, p);

            ans = skip || take;

        } else {
            // Normal character matching
            ans = match && solve(i + 1, j + 1, s, p);
        }

        memo[i][j] = ans;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];

        return solve(0, 0, s, p);
    }
}