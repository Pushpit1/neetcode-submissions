class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        int pathSum = root.val + left + right;
        maxSum = Math.max(maxSum, pathSum);

        return root.val + Math.max(left, right);
    }
}