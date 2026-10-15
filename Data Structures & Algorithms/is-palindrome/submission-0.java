class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] x = s.toCharArray();

        while (left < right) {
            if (!Character.isLetterOrDigit(x[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(x[right])) {
                right--;
            } else if (Character.toLowerCase(x[left])
                    != Character.toLowerCase(x[right])) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
