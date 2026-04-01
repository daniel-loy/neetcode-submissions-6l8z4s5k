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
    public boolean isBalanced(TreeNode root) {
        if(dfs(root) == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftmax = dfs(root.left);
        int rightmax = dfs(root.right);

        if(leftmax == -1 || rightmax == -1 || Math.abs(leftmax-rightmax)>1){
            return -1;
        }

        return Math.max(leftmax,rightmax)+1;
    }
}
