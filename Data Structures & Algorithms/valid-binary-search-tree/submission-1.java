class Solution {
    public boolean isValidBST(TreeNode root) {
        return bsf(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean bsf(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }

        int val = root.val;

        // Current node must respect bounds
        if (val <= min || val >= max) {
            return false;
        }

        // Left subtree must be < val
        if (!bsf(root.left, val, min)) {
            return false;
        }

        // Right subtree must be > val
        if (!bsf(root.right, max, val)) {
            return false;
        }

        return true;
    }
}
