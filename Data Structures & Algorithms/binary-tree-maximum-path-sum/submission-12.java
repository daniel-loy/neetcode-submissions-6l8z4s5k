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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return Math.max(calmax(root),max);
    }

    public int calmax(TreeNode root){
    if(root == null){
        return 0;
    }
     int leftmax = calmax(root.left);
     int rightmax = calmax(root.right);
    
    max =Math.max(Math.max(root.val+leftmax+rightmax,max),root.val);

    return Math.max(Math.max(root.val+leftmax,root.val+rightmax),root.val);
    }
}
