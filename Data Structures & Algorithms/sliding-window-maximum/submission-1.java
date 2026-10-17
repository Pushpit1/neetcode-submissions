class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int idx = 0;
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int right = 0; right < nums.length; right++) {

            // Remove smaller elements from the back
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[right]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(right);

            // Shrink the window
            while (right - left + 1 > k) {
                left++;
            }

            // Remove indices outside the window
            while (!dq.isEmpty() && dq.peekFirst() < left) {
                dq.pollFirst();
            }

            // Store maximum
            if (right - left + 1 == k) {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}