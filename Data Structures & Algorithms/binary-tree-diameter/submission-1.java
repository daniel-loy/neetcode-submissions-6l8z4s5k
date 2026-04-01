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
    int max=0;

    public int diameterOfBinaryTree(TreeNode root){
            maxdiameter(root);
            return max;
    }

    public int maxdiameter(TreeNode root){
                if(root==null){
            return 0;
        }
        int rightmax=maxdiameter(root.right);
        int leftmax=maxdiameter(root.left);
        if(rightmax+leftmax>max){
            max=rightmax+leftmax;
        }
        return Math.max(leftmax,rightmax)+1;
    }
}
