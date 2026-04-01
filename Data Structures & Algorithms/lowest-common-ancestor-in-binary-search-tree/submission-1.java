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
    TreeNode CommonAncestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        SublowestCommonAncestor(root,p,q);
        return CommonAncestor;
    }

    public boolean SublowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null){
        return false;
       }
       boolean value1 = SublowestCommonAncestor(root.left,p,q);
       boolean value2 = SublowestCommonAncestor(root.right,p,q);
       if(value1 && value2){
        CommonAncestor=root;
       }
       else if((value1 || value2) && (root.val == p.val || root.val == q.val )){
            CommonAncestor=root;
       }
       if(root.val == p.val || root.val == q.val || value1 || value2 ){
        return true;
       }
       else{
        return false;
       }
    }
}