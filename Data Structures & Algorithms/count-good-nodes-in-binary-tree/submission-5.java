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

        dfs(root,Integer.MIN_VALUE);
        return list.size();
        
    }

    public void dfs(TreeNode root,int level){
        if(root == null){
            return;
        }

        if(root.val >= level){
            list.add(root.val);
            level = root.val;
        }

        dfs(root.left,level);
        dfs(root.right,level);
    }
}
