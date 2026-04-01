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
    int maxlength = 0;
    public int goodNodes(TreeNode root) {
    
        dfs(root,Integer.MIN_VALUE);
        return maxlength;
    }

    public void dfs(TreeNode root,int maxvalue){
        if(root == null){
            return;
        }

        if(root.val>=maxvalue){
            maxlength++;
        }

        dfs(root.left,Math.max(maxvalue,root.val));
        dfs(root.right,Math.max(maxvalue,root.val));
        
    }
}
