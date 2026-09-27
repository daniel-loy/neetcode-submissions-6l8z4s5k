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
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k,0);
        return result;
    }

    public int dfs(TreeNode root,int k,int currentval){
        if(root == null){
            return currentval;
        }

        int left =  dfs(root.left,k,currentval);
        if(left+1 == k){
            result = root.val;
        }
        return dfs(root.right,k,left+1);
    }
}
