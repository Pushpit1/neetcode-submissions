/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>() ;
        if (root == null) return ans ;
        Queue<TreeNode>q = new LinkedList<>() ;
        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size() ;
            List<Integer> l = new ArrayList<>() ;
            for(int i = 0 ; i<s ; i++){
                TreeNode parent = q.poll() ;
                l.add(parent.val);
                if(parent.left!=null){    q.offer(parent.left) ; }
                if(parent.right!=null){    q.offer(parent.right) ; }
            }
            ans.add(l) ;
        }
        return ans ;
    }
}
