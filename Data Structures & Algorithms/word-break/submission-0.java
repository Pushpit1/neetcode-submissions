class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        HashSet<String> st = new HashSet<>(wordDict);
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
               if (st.contains(s.substring(start, end + 1))) {

                    if (start == 0 || dp[start - 1]) {
                        dp[end] = true;
                    }
                }
            }
                
        }
        return dp[s.length()- 1];
    }
}
