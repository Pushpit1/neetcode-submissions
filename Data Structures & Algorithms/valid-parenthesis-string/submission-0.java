class Solution {
    public boolean checkValidString(String s) {
        int open = 0, star = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == '*') star++;
            else {
                if (open > 0) open--;
                else if (star > 0) star--;
                else return false;
            }
        }

        int close = 0;
        star = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == ')') close++;
            else if (c == '*') star++;
            else {
                if (close > 0) close--;
                else if (star > 0) star--;
                else return false;
            }
        }

        return true;
    }
}