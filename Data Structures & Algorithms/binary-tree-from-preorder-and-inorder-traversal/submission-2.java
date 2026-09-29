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
	int i=0;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
	for(int i=0;i<inorder.length;i++){
		map.put(inorder[i],i);
	}
        return dfs(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder,int left,int right){
	if(i<0 || i>=preorder.length){
		return null;
	}
	if(left>right){
        i--;
		return null;
	}
    TreeNode root = new TreeNode(preorder[i]);
	int currentvalue = i;
	i++;
	root.left = dfs(preorder,inorder,left,map.get(preorder[currentvalue])-1);
	i++;
	root.right = dfs(preorder,inorder,map.get(preorder[currentvalue])+1,right);
    return root;
   }
}   
