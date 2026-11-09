class Solution {
    public List<Integer> partitionLabels(String s) {
        int left = 0;
        ArrayList<Integer> a = new ArrayList<>();
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int right = last[s.charAt(0) - 'a'];
        while (left < s.length()) {
            for (int i = left; i <= right; i++) {
                right = Math.max(right, last[s.charAt(i) - 'a']);
            }

            a.add(right - left + 1);

             left = right + 1;

            if (left < s.length()) {
                right = last[s.charAt(left) - 'a'];
            }
        }

        return a;
    }
}
