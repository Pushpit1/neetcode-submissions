
class Solution {
    boolean check(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }

        if (root.val <= low || root.val >= high) {
            return false;
        }

        return check(root.left, low, root.val)
            && check(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
