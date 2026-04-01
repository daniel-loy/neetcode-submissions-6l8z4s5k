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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return SameTree(p,q)!=-1;
    }
    public int SameTree(TreeNode p,TreeNode q){

        if(p==null && q==null){
            return 1;
        }
        if(p==null || q==null){
            return -1;
        }

        if(p.val!=q.val){
            return -1;
        }

        int leftbalance = SameTree(p.left,q.left);
        if(leftbalance==-1) return -1;
        int rightbalance = SameTree(p.right,q.right);
        if(rightbalance == -1) return -1;

        return 1;
    }
}
