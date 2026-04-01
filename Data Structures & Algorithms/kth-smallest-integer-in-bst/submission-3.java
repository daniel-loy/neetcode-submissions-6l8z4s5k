class Solution {
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
	return result;
    }
    public void dfs(TreeNode root,int K){
	if(root == null || count>K){
		return;
	}
	dfs(root.left,K);
	count++;
	if(count == K){
	result = root.val;
	}
	dfs(root.right,K);

   }
}
