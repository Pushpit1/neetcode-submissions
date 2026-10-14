class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = arr[i][0] + arr[j][0];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[] {Math.min(arr[i][1], arr[j][1]), Math.max(arr[i][1], arr[j][1])};
            }
        }
        return new int[] {};
    }
}
