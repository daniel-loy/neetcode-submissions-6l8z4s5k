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
    int max=-1001;
    public int maxPathSum(TreeNode root) {
            findSumNode(root);
            return max;

    }

    public int findSumNode(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = Math.max(findSumNode(root.left),0);
        int right = Math.max(findSumNode(root.right),0);
        int internalmax=0;


        if(root.val+left+right>max){
            max = root.val+left+right;
        }

        internalmax = Math.max(root.val+left,root.val+right);

        if(root.val>internalmax){
            internalmax = root.val;
        }

        return internalmax;
    }
}
