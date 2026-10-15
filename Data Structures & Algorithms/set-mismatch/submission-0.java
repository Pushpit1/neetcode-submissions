
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        for (int x : nums) {
            freq[x]++;
        }

        int dup = 0;
        int notfound = 0;

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                dup = i;
            } else if (freq[i] == 0) {
                notfound = i;
            }
        }

        return new int[]{dup, notfound};
    }
}
