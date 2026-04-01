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
    boolean subtreeBalanceCount = true;
    public boolean isBalanced(TreeNode root) {
            balanceBinarytree(root);
            return subtreeBalanceCount;
    }

       public int balanceBinarytree(TreeNode root){
                if(root==null){
            return 0;
        }
        int rightmax=balanceBinarytree(root.right);
        int leftmax=balanceBinarytree(root.left);
        if(Math.abs(rightmax-leftmax)>1){
            subtreeBalanceCount=false;
        }
        return Math.max(leftmax,rightmax)+1;
    }
}
