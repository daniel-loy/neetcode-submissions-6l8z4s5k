class Solution {
    int result = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        // Visit left
        dfs(root.left, k);

        // Visit root
        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        // Visit right
        dfs(root.right, k);
    }
}