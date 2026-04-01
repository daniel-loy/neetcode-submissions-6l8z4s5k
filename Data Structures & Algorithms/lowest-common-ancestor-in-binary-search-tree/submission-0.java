class Solution {
    private TreeNode commonAncestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return commonAncestor;
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);
        boolean mid = (root.val == p.val || root.val == q.val);

        if ((left && right) || (mid && (left || right))) {
            commonAncestor = root;
        }

        return mid || left || right;
    }
}
