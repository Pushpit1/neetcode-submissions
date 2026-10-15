
class Solution {
    boolean check(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean left = check(p.left, q.left);
        boolean right = check(p.right, q.right);

        return left && right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }
}
