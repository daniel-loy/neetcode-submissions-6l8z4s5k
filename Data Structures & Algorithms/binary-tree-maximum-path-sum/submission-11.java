class Solution {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root);
	    return result;
    }

    public int dfs(TreeNode node){

	if(node == null){
		return 0;
	}

	int leftmax = Math.max(dfs(node.left),0);
	int rightmax = Math.max(dfs(node.right),0);

	result = Math.max(result,Math.max(leftmax+rightmax+node.val,node.val));
	return Math.max(node.val,Math.max(leftmax+node.val,rightmax+node.val));
  }
}