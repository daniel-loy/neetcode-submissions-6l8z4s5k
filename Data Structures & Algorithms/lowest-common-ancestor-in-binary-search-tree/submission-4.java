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
            TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root,p,q);
            return result;
    }

    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return false;
        }
        boolean left = dfs(root.left,p,q);
        boolean right = dfs(root.right,p,q);
        boolean rootval = false;
        if(root.val == p.val || root.val == q.val){
            rootval = true;
        }

        if((left && right) || (left && rootval) || (right && rootval)){
            result = root;
            return true;
        }

        if(left || right || rootval){
            return true;
        }
    
        return false;
    }
}
