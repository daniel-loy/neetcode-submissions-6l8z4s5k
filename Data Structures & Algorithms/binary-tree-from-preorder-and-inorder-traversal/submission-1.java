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
    int k=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bfs(new TreeNode(),preorder,inorder,0,inorder.length);
    
    }

    public TreeNode bfs(TreeNode root,int[] preorder, int[] inorder,int i,int j){
        if(i==j){
            return null;
        }
        int mid=i;
        while(preorder[k]!=inorder[mid])
        {
            mid++;
        }
        root.val=preorder[k];
        k++;
        root.left=bfs(new TreeNode(),preorder,inorder,i,mid);
        root.right=bfs(new TreeNode(),preorder,inorder,mid+1,j);
        return root;

    }
}
