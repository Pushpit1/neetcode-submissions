class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) required++;
        }

        int formed = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window[ch]++;

            if (need[ch] > 0 && window[ch] == need[ch]) {
                formed++;
            }

            while (formed == required) {
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (need[leftChar] > 0
                        && window[leftChar] == need[leftChar]) {
                    formed--;
                }

                window[leftChar]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}