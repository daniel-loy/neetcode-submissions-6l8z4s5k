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
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }


    public boolean dfs(TreeNode root,int left,int right){
        if(root == null){
            return true;
        }
        if(root.val>left && root.val<right){

            boolean leftvalid = dfs(root.left,left,root.val);
            if(!leftvalid) return false;

            boolean rightvalid = dfs(root.right,root.val,right);
            if(!rightvalid) return false;
            
        }
        else{
            return false;
        }

        return true;

    }
    
}
