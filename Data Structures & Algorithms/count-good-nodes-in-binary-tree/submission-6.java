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
    List<Integer> list = new ArrayList<Integer>();
    public int goodNodes(TreeNode root) {

        int count = dfs(root,Integer.MIN_VALUE);
        return count;
        
    }

    public int dfs(TreeNode root,int level){
        if(root == null){
            return 0;
        }

        if(root.val >= level){
            level = root.val;
        }

        int leftcount = dfs(root.left,level);
        int rightcount = dfs(root.right,level);

        if(root.val == level){
            return leftcount+rightcount+1;
        }
        else{
            return leftcount+rightcount;
        }
    }
}
