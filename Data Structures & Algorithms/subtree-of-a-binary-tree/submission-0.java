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
    boolean sametree(TreeNode big , TreeNode small){
    if(big==null && small==null){ return true ;}
    if(big==null || small==null){ return false ;}

    if(big.val !=small.val){return false ;}

    return sametree(big.left , small.left) && sametree(big.right ,small.right);
       
    } 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if(root==null){return false;}

    if (sametree(root, subRoot)) return true;
    return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);

    }
}
