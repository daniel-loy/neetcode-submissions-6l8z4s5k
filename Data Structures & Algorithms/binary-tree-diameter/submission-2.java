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
    int maxlength = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxlength;
    }

    public int dfs(TreeNode root){
                if(root == null){
            return 0;
        }
        int leftmax = dfs(root.left);
        int rightmax = dfs(root.right);
        System.out.println(root.val+" "+leftmax+" "+rightmax+" "+maxlength);
        maxlength = Math.max(maxlength,leftmax+rightmax);
        return Math.max(leftmax,rightmax)+1;
    }
}
