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
    public int goodNodes(TreeNode root) {
    
        return dfs(root,Integer.MIN_VALUE,0);
    }

    public int dfs(TreeNode root,int maxvalue,int totalcount){
        if(root == null){
            return totalcount;
        }

        if(root.val>=maxvalue){
            totalcount++;
        }

        int leftmax = dfs(root.left,Math.max(maxvalue,root.val),totalcount);
        int rightmax = dfs(root.right,Math.max(maxvalue,root.val),leftmax);
        return rightmax;
    }
}
